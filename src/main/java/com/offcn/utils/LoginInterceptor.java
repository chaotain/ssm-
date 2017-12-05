package com.offcn.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//静态文件
	 public List<String> excutMaperURL;
	//执行视图解析之后执行
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//在执行controller执行之后执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//在请求之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//获取请求路径
		String url = request.getRequestURI();
		//判断是不是静态文件
		int postfix = url.lastIndexOf(".");
		if(postfix>-1){
			String postFixStr = url.substring(postfix);
			if(excutMaperURL.contains(postFixStr)){
				return true;
			}else{
				return false;
			}
		}else{
			if(!url.contains("/login")){
				HttpSession session = request.getSession();
				if(session.getAttribute("user")!=null){
					return true;
				}else{
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return false;
				}
			}
		}
		return true;
	}

	public List<String> getExcutMaperURL() {
		return excutMaperURL;
	}

	public void setExcutMaperURL(List<String> excutMaperURL) {
		this.excutMaperURL = excutMaperURL;
	}
	
	

}
