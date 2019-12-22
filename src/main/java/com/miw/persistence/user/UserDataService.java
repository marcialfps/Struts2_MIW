package com.miw.persistence.user;

import java.util.List;

import com.miw.model.User;

public interface UserDataService {

	List<User> getUsers() throws Exception;
	void saveUser(User u) throws Exception;
}
