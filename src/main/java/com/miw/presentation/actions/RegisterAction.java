package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.miw.model.UserInfo;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Result(name="success", location="/index.jsp")

@Validations(
		requiredStrings = {
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.username", key = "login.required"),
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.password", key = "password.required"),
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.passwordRepeat", key = "password-repeat.required"),
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.email", key = "email.required")},
		emails = { 
				@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "user.email", key = "email.invalid")})

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
	
	@Override
	public void validate() {
		logger.debug("Validating user information.");
		UserManagerServiceHelper helper = new UserManagerServiceHelper();
		
		if (!user.getPassword().equals(user.getPasswordRepeat())) {
			addFieldError("user.passwordRepeat", getText("password-not-equal"));
		}
		
		try {
			for (User u: helper.getUsers()) {
				if (u.getUsername().equals(user.getUsername())) {
					addFieldError("user.username", getText("user-exists"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
