package com.offcn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.offcn.po.AddStuExt;
import com.offcn.po.CtcKey;
import com.offcn.po.Student;
import com.offcn.po.StudentExt;

public interface StudentService {
	public List<StudentExt> getStuList(int pageNO,int size);
	public int getCount();
	public void addsave(AddStuExt student);
	public void delete(int id);
	public void deletes(int [] ids);
	public Student getEditStu(int id);
	public void editsave(Student student);
	public Student seleteById(int id);
	void updatePwd(int rid,String password);
	List<Student> getCourseById(int id);
	int getClassid(int id);
	List<CtcKey> selectCourse(int claid);
	void multiIsert(String [] ids,HttpServletRequest request);
}
