package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.ClassesMapper;
import com.offcn.po.Classes;
@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	ClassesMapper classesMapper;
	@Override
	public List<Classes> getClassList() {
		
		return classesMapper.getClassList();
	}

}
