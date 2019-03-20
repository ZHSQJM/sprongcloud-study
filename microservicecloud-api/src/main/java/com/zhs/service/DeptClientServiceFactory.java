package com.zhs.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zhs.entity.Dept;

import feign.hystrix.FallbackFactory;


@Component
public class DeptClientServiceFactory implements FallbackFactory<IDeptClientService> {

	@Override
	public IDeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new IDeptClientService(){

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Dept get(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDname("该ID"+id+"没有对应信息，null--@HystrixCommand")
						.setDb_source("no this database in MySQL")
						.setDeptno(1);
			}

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
