package com.offcn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.po.Login;
import com.offcn.service.LoginService;
import com.offcn.service.StudentService;

@Controller
public class LoginController {
	@Resource
	LoginService loginService;
	@Resource
	StudentService studentService;
	@RequestMapping("login")
	public String login(Model model,HttpServletRequest request,Login login){
		Login loginuser = loginService.getlogin(login);		
		if(loginuser!=null){
			if(loginuser.getRole()==3){
				int classid = studentService.getClassid(loginuser.getRid());
				request.getSession().setAttribute("user", loginuser);
				request.getSession().setAttribute("classid", classid);
				return "homepage/index";
			}else{
				request.getSession().setAttribute("user", loginuser);
				return "homepage/index";
			}
			
		}else{
			model.addAttribute("msg", "µÇÂ¼Ê§°Ü");
			return "login";
		}
		
	}
}
