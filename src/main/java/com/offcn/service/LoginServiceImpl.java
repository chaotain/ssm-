package com.offcn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.offcn.dao.LoginMapper;
import com.offcn.po.Login;
@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	LoginMapper loginMapper;
	@Override
	public Login getlogin(Login login) {
		Login log = loginMapper.login(login);
		return log;
	}
	@Override
	public void delete(int rid) {
		loginMapper.delete(rid);
		
	}
	@Override
	public void deletes(int[] ids) {
		for(int id:ids){
			this.delete(id);
		}
		
	}

}
