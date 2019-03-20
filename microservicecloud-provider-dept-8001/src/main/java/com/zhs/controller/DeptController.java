package com.zhs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhs.entity.Dept;
import com.zhs.service.IDeptService;

@RestController
public class DeptController {
	
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private DiscoveryClient client;
	
	@PostMapping(value="dept/add")
	public boolean add(@RequestBody Dept dept){
		return deptService.add(dept);
	}
	
	@GetMapping(value="dept/get/{id}")
	public Dept get(@PathVariable("id")Long id){
		return deptService.get(id);
	}

	@GetMapping(value="dept/list")
	public List<Dept> list(){
		return deptService.list();
	}
	
	@GetMapping(value="/dept/discovery")
	public Object discovery(){
		
		List<String> list = client.getServices();
		System.out.println("*********"+list);
		List<ServiceInstance> srvlist = client.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance element : srvlist){
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+
					"\t"+element.getUri());
		
		}
		return this.client;
	}
}
