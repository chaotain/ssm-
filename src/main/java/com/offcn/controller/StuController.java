package com.offcn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offcn.po.AddStuExt;
import com.offcn.po.Classes;
import com.offcn.po.CtcKey;
import com.offcn.po.Grade;
import com.offcn.po.Login;
import com.offcn.po.Student;
import com.offcn.po.StudentExt;
import com.offcn.service.ClassService;
import com.offcn.service.GradeService;
import com.offcn.service.LoginService;
import com.offcn.service.StudentService;

@Controller
@RequestMapping("stu")
public class StuController {
	@Resource
	StudentService studentService;
	@Autowired
	ClassService classService;
	@Resource
	LoginService loginService;
	@Resource
	GradeService gradeService;
	@RequestMapping
	public String getStuList(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
		int size=3;
		List<StudentExt> stulist = studentService.getStuList(pageNO,size);
		model.addAttribute("stulist", stulist);
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("count", studentService.getCount());
		return "stu/list";
	}
	@RequestMapping("/showadd")
	public String showadd(Model model){
		List<Classes> clalist = classService.getClassList();
		model.addAttribute("clalist", clalist);
		model.addAttribute("student", new AddStuExt());
		return "stu/add";
	}
	@RequestMapping("/add")
	public String add(AddStuExt student){
		studentService.addsave(student);
		return "redirect:/stu";
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		studentService.delete(id);
		loginService.delete(id);
		return "redirect:/stu";
	}
	@RequestMapping("/deletes")
	public String deletes(@RequestParam("id")int [] ids){
		studentService.deletes(ids);
		loginService.deletes(ids);
		return "redirect:/stu";
	}
	@RequestMapping("/showedit/{id}")
	public String showedit(@PathVariable int id,Model model){
		Student student = studentService.getEditStu(id);
		List<Classes> clalist = classService.getClassList();
		model.addAttribute("clalist", clalist);
		model.addAttribute("student", student);
		return "stu/edit";
	}
	@RequestMapping("/edit")
	public String edit(Student student){
		studentService.editsave(student);
		return "redirect:/stu";
	}
	@RequestMapping("/showInfo/{id}")
	public String showInfo(@PathVariable("id") int id,Model model){
		Student student = studentService.seleteById(id);
		model.addAttribute("student", student);
		return "stu/person/list";
	}
	@RequestMapping("/updatePwd")
	public String updatePwd(Model model,int rid,String password){
		studentService.updatePwd(rid, password);
		Student student = studentService.seleteById(rid);
		model.addAttribute("student", student);
		return "stu/person/list";
	}
	@RequestMapping("/mycourse/{id}")
	public String mycourse(@PathVariable int id,Model model){
		 List<Student> stulist = studentService.getCourseById(id);
		 model.addAttribute("stulist", stulist);
		return "stu/person/mycourse";
	}
	/*@RequestMapping("/changeCouType")
	public String changeCouType(int rid){
		System.out.println(rid);
		return "";
	}*/
	@RequestMapping("/selectCourse/{classid}")
	public String selectCourse(@PathVariable int classid,Model model){
		List<CtcKey> ctclist = studentService.selectCourse(classid);
		model.addAttribute("ctclist", ctclist);
		return "stu/person/selectcourse";
	}
	@RequestMapping("/savecourse")
	public String savecourse(String [] ids,HttpServletRequest request,Model model){
		Login user=(Login)request.getSession().getAttribute("user");
		int id=user.getRid();
		studentService.multiIsert(ids, request);
		List<Student> stulist = studentService.getCourseById(id);
		model.addAttribute("stulist", stulist);
		return "stu/person/mycourse";
	}
	@RequestMapping("/getGrade/{id}")
	public String getGrade(Model model,@PathVariable int id){
		List<Grade> gralist = gradeService.getListBySid(id);
		model.addAttribute("gradelist", gralist);
		return "stu/person/grade";
	}
}
