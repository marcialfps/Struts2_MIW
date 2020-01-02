package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value ="miw.Amazin")

@Result(name = "error", location = "/index.jsp")

public class ShowBooksAction extends ActionSupport implements ApplicationAware, SessionAware  {
	
	private static final long serialVersionUID = -4752542581534740735L;
	Logger logger = Logger.getLogger(this.getClass());
	Map<String,Object> application = null;
	private Map<String, Object> session = null;

	public String execute() {
		logger.debug("Executing ShowBooksCommand");
		
		if (session.containsKey("loginInfo")) {
			BookManagerServiceHelper helper = new BookManagerServiceHelper();
			try {
				application.put("books", helper.getBooks());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
