package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value ="miw.Amazin")

@Result(name = "error", location = "/index.jsp")

public class ShowSpecialOfferAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = 4674623943937761755L;
	Logger logger = Logger.getLogger(this.getClass());
	private Map<String,Object> request = null;
	private Map<String, Object> session = null;
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing "+this.getClass().getName());
		
		if (session.containsKey("loginInfo")) {
			BookManagerServiceHelper helper = new BookManagerServiceHelper();
			try {
				request.put("book", helper.getSpecialOffer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
			
		} else {
			return ERROR;
		}
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}	
}
