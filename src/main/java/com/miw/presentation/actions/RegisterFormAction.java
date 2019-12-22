package com.miw.presentation.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterFormAction extends ActionSupport {

	private static final long serialVersionUID = -8900978689176497649L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing RegisterFormAction");
		return SUCCESS;
	}

}
