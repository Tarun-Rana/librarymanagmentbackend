package com.cognizant.Library.Managment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Library.Managment.Repository.UserRepository;
import com.cognizant.Library.Managment.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	public User findByUserId(long id) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUserId(id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	



}
