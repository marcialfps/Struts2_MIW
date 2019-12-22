package com.miw.business.usermanager;

import java.util.List;

import com.miw.model.User;

public interface UserManagerService {
	public List<User> getUsers() throws Exception;
	public void saveUser(User u) throws Exception;
}
