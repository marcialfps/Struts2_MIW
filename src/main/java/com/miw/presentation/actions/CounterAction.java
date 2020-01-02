package com.miw.presentation.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.Counter;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="login-success.jsp" ),
	@Result(name = "error", location = "/index.jsp")
})


public class CounterAction extends ActionSupport implements ApplicationAware, SessionAware {

	private static final long serialVersionUID = 3754807639524838051L;
	private Map<String, Object> application = null;
	private Map<String, Object> session = null;
	
	@Override
	public String execute() throws Exception {
		if (session.containsKey("loginInfo")) {
			Counter counter = (Counter) application.get("counter");
			if ( counter == null )
			{
				counter = new Counter();
			}
			counter.increment();
			application.put("counter", counter);
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
