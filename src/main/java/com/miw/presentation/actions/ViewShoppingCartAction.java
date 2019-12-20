package com.miw.presentation.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class ViewShoppingCartAction extends ActionSupport {

	private static final long serialVersionUID = -1012329329075373942L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing ViewShoppingCartAction");
		return SUCCESS;
	}

}
