package com.offcn.service;

import java.util.List;

import com.offcn.po.Course;
import com.offcn.po.CourseExt;

public interface CourseService {

	List<Course> getCouList();
	
	CourseExt getById(int id);
	
	void insert(CourseExt courseExt);
}
