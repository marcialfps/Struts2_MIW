package com.miw.business.usermanager;

import java.util.List;

import org.apache.log4j.Logger;

import com.miw.business.UserDataServiceHelper;
import com.miw.model.User;

public class UserManager implements UserManagerService {
	Logger logger = Logger.getLogger(this.getClass());

	public List<User> getUsers() throws Exception {
		logger.debug("Asking for users");
		List<User> users = (new UserDataServiceHelper()).getUsers();
		
		return users;
	}

	public void saveUser(User u) throws Exception {
		logger.debug("Saving user");
		new UserDataServiceHelper().saveUser(u);
	}
}
