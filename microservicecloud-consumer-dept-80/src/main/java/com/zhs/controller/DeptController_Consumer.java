package com.zhs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zhs.entity.Dept;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {
	
	
	/**
	 * 通过微服务的服务名来访问  不通过固定IP来访问
	 */
	//private static final String REST_URL = "http://localhost:8001";
	private static final String REST_URL = "http://MICROSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping(value="/dept/add")
	public boolean add(Dept dept){
		
		return restTemplate.postForObject(REST_URL+"/dept/add", dept, Boolean.class);
		
	}
	
	@GetMapping(value="/dept/get/{id}")
	public Dept add(@PathVariable("id") long id){
		
		return restTemplate.getForObject(REST_URL+"/dept/get/"+id, Dept.class);
		
	}
	

	@SuppressWarnings("unchecked")
	@GetMapping(value="/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL+"/dept/list/", List.class);
	}

}
