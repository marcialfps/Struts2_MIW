package com.miw.presentation.user;

import java.util.List;

import org.apache.log4j.Logger;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserManagerServiceHelper {

	Logger logger = Logger.getLogger(this.getClass());
	
	public List<User> getUsers() throws Exception {
		logger.debug("Retrieving Users from Business Layer");
		return (Factories.services.getUserManagerService()).getUsers();
	}
	
	public void saveUser(User u) throws Exception {
		logger.debug("Saving User to Business Layer");
		Factories.services.getUserManagerService().saveUser(u);
	}
}
