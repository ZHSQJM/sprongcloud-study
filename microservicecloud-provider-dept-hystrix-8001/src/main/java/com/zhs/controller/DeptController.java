package com.zhs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhs.entity.Dept;
import com.zhs.service.IDeptService;

@RestController
public class DeptController {
	
	
	@Autowired
	private IDeptService deptService;
	
	

	
	@GetMapping(value="dept/get/{id}")
	//@HystrixCommand(fallbackMethod = "processHystrix_Get") //一旦服务调用失败并抛出错误信息后，自动调用@HystrixCommand标注好的fallbackMethod
	public Dept get(@PathVariable("id")Long id){
		Dept dept = deptService.get(id);
		if(null == dept){
			throw new RuntimeException("该ID:"+id+"没有对应的的信息");
		}
		return dept;
	}

	
	public Dept processHystrix_Get(@PathVariable("id") Long id){
	
		return new Dept().setDname("该ID"+id+"没有对应信息，null--@HystrixCommand")
				.setDb_source("no this database in MySQL")
				.setDeptno(1);
	}
}
