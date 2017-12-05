package com.offcn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.offcn.dao.CtcMapper;
import com.offcn.dao.LoginMapper;
import com.offcn.dao.ScMapper;
import com.offcn.dao.StudentMapper;
import com.offcn.po.AddStuExt;
import com.offcn.po.CtcKey;
import com.offcn.po.Login;
import com.offcn.po.Sc;
import com.offcn.po.Student;
import com.offcn.po.StudentExt;

@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	StudentMapper studentMapper;
	@Resource
	LoginMapper loginMapper;
	@Resource
	CtcMapper ctcMapper;
	@Resource
	ScMapper scMapper;
	@Override
	public List<StudentExt> getStuList(int pageNO,int size) {
		int start=(pageNO-1)*size;
		 List<StudentExt> list = studentMapper.getStuList(start, size);
		return list;
		
	}
	@Override
	public int getCount() {
		int n = studentMapper.getCount();
		return n;
	}
	@Override
	public void addsave(AddStuExt student) {
		Student stu = new Student();
		stu.setName(student.getName());
		stu.setSex(student.getSex());
		stu.setAddress(student.getAddress());
		stu.setTel(student.getTel());
		stu.setClassid(student.getClasses().getId());
		studentMapper.insert(stu);
		Login login = new Login();
		login.setLoginname(student.getLoginname());
		login.setPassword(student.getPassword());
		login.setRid(stu.getId());
		login.setRole(3);
		loginMapper.insert(login);
	}
	@Override
	public void delete(int id) {
		studentMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public void deletes(int[] ids) {
		for(int id:ids){
			this.delete(id);
		}
		
	}
	@Override
	public Student getEditStu(int id) {
		Student student = studentMapper.getEditStu(id);
		return student;
	}
	@Override
	public void editsave(Student student) {
		student.setClassid(student.getClasses().getId());
		studentMapper.updateByPrimaryKey(student);
		Login login = new Login();
		login.setLoginname(student.getLogin().getLoginname());
		login.setPassword(student.getLogin().getPassword());
		login.setId(student.getLogin().getId());
		loginMapper.updateByPrimaryKeySelective(login);
	}
	@Override
	public Student seleteById(int id) {
		Student stu = studentMapper.getEditStu(id);
		return stu;
	}
	@Override
	public void updatePwd(int rid,String password) {
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("rid", rid);
		map.put("password", password);
		loginMapper.updateByRid(map);
		
	}
	@Override
	public List<Student> getCourseById(int id) {
		List<Student> stulist = studentMapper.getCourseById(id);
		return stulist;
	}
	@Override
	public int getClassid(int id) {
		// TODO Auto-generated method stub
		return studentMapper.getClassid(id);
	}
	@Override
	public List<CtcKey> selectCourse(int claid) {
		List<CtcKey> ctclist = ctcMapper.selectCourse(claid);
		return ctclist;
	}
	@Override
	public void multiIsert(String [] ids,HttpServletRequest request) {
		List<Sc>sclist = new ArrayList<Sc>();
		for(String id:ids){
			Sc sc= new Sc();
			String[]arr=id.split("_");
			Login user=(Login)request.getSession().getAttribute("user");
			sc.setSid(user.getRid());
			sc.setCid(Integer.valueOf(arr[0]));
			sc.setTid(Integer.valueOf(arr[1]));
			sclist.add(sc);
		}
		scMapper.multiIsert(sclist);
	}


}
