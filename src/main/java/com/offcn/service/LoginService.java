package com.offcn.service;

import com.offcn.po.Login;

public interface LoginService {

	public Login getlogin(Login login);
	public void delete(int rid);
	public void deletes(int [] ids);
}
