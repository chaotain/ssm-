package com.offcn.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//��̬�ļ�
	 public List<String> excutMaperURL;
	//ִ����ͼ����֮��ִ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//��ִ��controllerִ��֮��ִ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//������֮ǰִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//��ȡ����·��
		String url = request.getRequestURI();
		//�ж��ǲ��Ǿ�̬�ļ�
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
