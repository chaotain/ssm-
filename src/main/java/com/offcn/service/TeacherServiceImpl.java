package com.offcn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.offcn.dao.LoginMapper;
import com.offcn.dao.TeacherMapper;
import com.offcn.dao.TeatypeMapper;
import com.offcn.po.AddTeaExt;
import com.offcn.po.Login;
import com.offcn.po.Teacher;
import com.offcn.po.Teatype;
@Service
public class TeacherServiceImpl implements TeacherService{

	@Resource
	TeacherMapper teacherMapper;
	@Resource
	TeatypeMapper teatypeMapper;
	@Resource
	LoginMapper loginMapper;
	@Override
	public List<Teacher> getTeaList() {
		return teacherMapper.getTeaList();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return teacherMapper.getCount();
	}
	@Override
	public List<Teatype> getTyList() {
		// TODO Auto-generated method stub
		return teatypeMapper.getTeaList();
	}
	@Override
	public void addsave(AddTeaExt addTeaExt) {
		Teacher teacher = new Teacher();
		teacher.setName(addTeaExt.getName());
		teacher.setWorkid(addTeaExt.getWorkid());
		teacher.setType(addTeaExt.getTeatype().getId());
		teacherMapper.insert(teacher);
		Login login = new Login();
		login.setLoginname(addTeaExt.getLoginname());
		login.setPassword(addTeaExt.getPassword());
		login.setRole(2);
		login.setRid(teacher.getId());
		loginMapper.insert(login);
	}

}
