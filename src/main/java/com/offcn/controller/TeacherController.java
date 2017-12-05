package com.offcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offcn.po.AddTeaExt;
import com.offcn.po.Teacher;
import com.offcn.po.Teatype;
import com.offcn.service.TeacherService;

@Controller
@RequestMapping("tea")
public class TeacherController {

	@Resource
	TeacherService teacherService;
	@RequestMapping
	public String getTeaList(Model model){	
		List<Teacher> tealist = teacherService.getTeaList();
		model.addAttribute("tealist", tealist);
		return "teacher/list";
	}
	@RequestMapping("/showadd")
	public String showadd(Model model){
		AddTeaExt teacher = new AddTeaExt();
		List<Teatype> tealist = teacherService.getTyList();
		model.addAttribute("teacher", teacher);
		model.addAttribute("tealist", tealist);
		return "teacher/add";
	}
	@RequestMapping("/add")
	public String add(AddTeaExt addTeaExt){
		teacherService.addsave(addTeaExt);
		return "redirect:/tea";
	}
}
