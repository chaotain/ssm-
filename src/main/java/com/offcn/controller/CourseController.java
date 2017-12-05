package com.offcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.po.Course;
import com.offcn.po.CourseExt;
import com.offcn.service.ClassService;
import com.offcn.service.CourseService;
import com.offcn.service.TeacherService;

@Controller
@RequestMapping("cou")
public class CourseController {

	@Resource
	CourseService courseService;
	@Resource
	ClassService classService;
	@Resource
	TeacherService teacherService;
	@RequestMapping
	public String getAll(Model model){
		List<Course> coulist = courseService.getCouList();
		model.addAttribute("coulist", coulist);
		return "/course/list";
	}
	@RequestMapping("/ctc/{id}")
	public String ctc(Model model,@PathVariable int id){
		CourseExt course = courseService.getById(id);
		model.addAttribute("course", course);
		model.addAttribute("clalist", classService.getClassList());
		model.addAttribute("tealist", teacherService.getTeaList());
		return "/course/setct";
	}
	@RequestMapping("/editSavect")
	public String editSavect(CourseExt courseExt){
		courseService.insert(courseExt);
		return "redirect:/cou";
	}
}
