package com.cognizant.Library.Managment.Service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.Library.Managment.model.User;

@Repository
public interface UserService {
	
	public User findByUserId(long id);
	
	public List<User> findAllUser();
	
	public User findByEmail(String email);

}
