package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.miw.model.UserInfo;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="/index.jsp" )

public class RegisterAction extends ActionSupport implements RequestAware {
	
	private static final long serialVersionUID = -5986754708093016582L;
	Logger logger = Logger.getLogger(this.getClass());
	private UserInfo user = null;
	private Map<String, Object> request;
	
	@Override
	public String execute() throws Exception {
		UserManagerServiceHelper helper = new UserManagerServiceHelper();
		
		try {
			helper.saveUser(new User(user.getUsername(), user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
}
