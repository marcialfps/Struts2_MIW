package com.miw.presentation.actions;

import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.I18nInterceptor;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success", location = "/index.jsp")

public class LanguageAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 5851305016625876075L;
	private Map<String, Object> session = null;
	
	@Override
	public String execute() throws Exception {
		logger.debug("Changing language");
		Locale actualLocale = ActionContext.getContext().getLocale();
		Locale newLocale = null;
		
		if (actualLocale.getLanguage().equals(new Locale("es").getLanguage())) {
			newLocale = Locale.ENGLISH;
		} else {
			newLocale = Locale.forLanguageTag("es-ES");
		}
		
		ActionContext.getContext().setLocale(newLocale);
		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, newLocale);
		
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
