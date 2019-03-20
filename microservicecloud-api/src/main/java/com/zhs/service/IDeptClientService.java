package com.zhs.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zhs.entity.Dept;


@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFactory.class)
public interface IDeptClientService {

	@PostMapping(value = "/dept/add")
    public boolean add(Dept dept);
	
    @GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id);
	
    @GetMapping(value = "/dept/list")
	public List<Dept> list();
}
