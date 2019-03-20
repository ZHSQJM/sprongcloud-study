package com.zhs.service;


import java.util.List;

import com.zhs.entity.Dept;

public interface IDeptService {
	
	public boolean add(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list();

}
