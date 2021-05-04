package com.cognizant.Library.Managment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Library.Managment.Exception.UserAlreadyExistException;
import com.cognizant.Library.Managment.Service.AppUserDetailService;
import com.cognizant.Library.Managment.Service.UserService;
import com.cognizant.Library.Managment.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AppUserDetailService appUserDetailService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) throws UserAlreadyExistException{
		System.out.println(user);
		return appUserDetailService.Signup(user);
	}
	
	@GetMapping("/get/{email}")
	public User getUser( @PathVariable String email){
		return userService.findByEmail(email);
	}
}
