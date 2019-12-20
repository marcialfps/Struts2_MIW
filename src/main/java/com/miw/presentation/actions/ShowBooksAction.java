package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value ="miw.Amazin")

public class ShowBooksAction extends ActionSupport implements ApplicationAware  {
	
	private static final long serialVersionUID = -4752542581534740735L;
	Logger logger = Logger.getLogger(this.getClass());
	Map<String,Object> application = null;

	public String execute() {
		logger.debug("Executing ShowBooksCommand");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			application.put("books", helper.getBooks());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	
}
