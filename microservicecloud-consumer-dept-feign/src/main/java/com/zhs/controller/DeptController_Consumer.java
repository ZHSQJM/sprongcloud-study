package com.zhs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhs.entity.Dept;
import com.zhs.service.IDeptClientService;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {
	
	
	
	
	@Autowired
	private IDeptClientService deptService;
	
	
	@PostMapping(value="/dept/add")
	public boolean add(Dept dept){
		

		return deptService.add(dept);
	}
	
	@GetMapping(value="/dept/get/{id}")
	public Dept add(@PathVariable("id") long id){
		
		return deptService.get(id);
		
	}
	

	@GetMapping(value="/dept/list")
	public List<Dept> list(){
		return deptService.list();
	}

}
