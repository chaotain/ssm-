package com.offcn.service;

import java.util.List;

import com.offcn.po.AddTeaExt;
import com.offcn.po.Teacher;
import com.offcn.po.Teatype;

public interface TeacherService {

	public List<Teacher> getTeaList();
	public int getCount();
	List<Teatype> getTyList();
	void addsave(AddTeaExt addTeaExt);
}
