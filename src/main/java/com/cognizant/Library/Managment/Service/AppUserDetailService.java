package com.cognizant.Library.Managment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.Library.Managment.Exception.UserAlreadyExistException;
import com.cognizant.Library.Managment.Repository.UserRepository;
import com.cognizant.Library.Managment.Security.AppUser;
import com.cognizant.Library.Managment.model.User;
import com.sun.xml.bind.v2.runtime.output.Encoded;

@Service
public class AppUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	
	AppUser appUser;
	
	public AppUserDetailService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserDetailService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public AppUserDetailService(UserRepository userRepository, AppUser appUser) {
		super();
		this.userRepository = userRepository;
		this.appUser = appUser;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("username not found");
			
		}
		else{
			appUser = new AppUser(user);
		}
		return appUser;
	}
	
	public User Signup(User newUser) throws UserAlreadyExistException{
		User user;
		System.out.println("in signup function");
		user = userRepository.findByEmail(newUser.getEmail());
		
		if(user == null){
			newUser.setRole("ROLE_USER");
			System.out.println(newUser);
			newUser.setPassword(passwordEncoder().encode(newUser.getPassword()));
			System.out.println("h1");
			userRepository.save(newUser);
			System.out.println("successfull");
			return newUser;
		}
		else{
			throw new UserAlreadyExistException();
		}
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
