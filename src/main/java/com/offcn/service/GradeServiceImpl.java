package com.offcn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.offcn.dao.GradeMapper;
import com.offcn.po.Grade;
@Service
public class GradeServiceImpl implements GradeService{

	@Resource
	GradeMapper gradeMapper;
	@Override
	public List<Grade> getListBySid(int id) {
		
		return gradeMapper.getListBySid(id);
	}

}
