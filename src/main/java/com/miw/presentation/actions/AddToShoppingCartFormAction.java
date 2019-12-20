package com.miw.presentation.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class AddToShoppingCartFormAction extends ActionSupport {

	private static final long serialVersionUID = 2928936471686062365L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing AddToShoppingCartFormAction");
		return SUCCESS;
	}

}
