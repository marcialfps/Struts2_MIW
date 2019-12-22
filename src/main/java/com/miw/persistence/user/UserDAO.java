package com.miw.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {
	
	protected Logger logger = Logger.getLogger(getClass());

	public List<User> getUsers() throws Exception {
		List<User> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From User a", User.class).getResultList();

			logger.debug("Result list: "+ resultList.toString());
			for (User next : resultList) {
				logger.debug("next user: " + next);
			}

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}

	@Transactional
	public void saveUser(User u) {
		Dba dba = new Dba();
			
		EntityManager em = dba.getActiveEm();
		
	    em.createNativeQuery("Insert into user (id, username, email, password) VALUES (?,?,?,?)")
	      .setParameter(1, u.getId())
	      .setParameter(2, u.getUsername())
	      .setParameter(3, u.getEmail())
	      .setParameter(4, u.getPassword())
	      .executeUpdate();
	    
	    dba.closeEm();
	}
}
