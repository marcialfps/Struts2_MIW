package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Result(name = "error", location = "/index.jsp")

public class AddToShoppingCartFormAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2928936471686062365L;
	Logger logger = Logger.getLogger(this.getClass());
	private Map<String, Object> session = null;
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing AddToShoppingCartFormAction");
		
		if (session.containsKey("loginInfo")) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
