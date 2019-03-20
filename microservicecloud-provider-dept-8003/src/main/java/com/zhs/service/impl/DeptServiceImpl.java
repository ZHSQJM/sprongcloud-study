package com.zhs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhs.dao.DeptDao;
import com.zhs.entity.Dept;
import com.zhs.service.IDeptService;


@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private DeptDao deptDao;
	
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
