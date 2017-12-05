package com.offcn.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.offcn.dao.CourseMapper;
import com.offcn.dao.CtcMapper;
import com.offcn.po.Course;
import com.offcn.po.CourseExt;
import com.offcn.po.CtcKey;

@Service
public class CourseServiceImpl implements CourseService{

	@Resource
	CourseMapper courseMapper;
	@Resource
	CtcMapper ctcMapper;
	@Override
	public List<Course> getCouList() {
		return courseMapper.getCouAll();
	}
	@Override
	public CourseExt getById(int id) {
		// TODO Auto-generated method stub
		CourseExt course = courseMapper.selectByPrimaryKey(id);
		return course;
	}
	@Override
	public void insert(CourseExt courseExt) {
		List<Integer> ids = courseExt.getClaids();
		List<CtcKey> list = new ArrayList<CtcKey>();
		for(int id:ids){
			CtcKey ct = new CtcKey();
			ct.setTid(Integer.parseInt(courseExt.getTid()));
			ct.setCouid(courseExt.getId());
			ct.setClaid(id);
			list.add(ct);
		}
		ctcMapper.insertCtc(list);
	}

}
