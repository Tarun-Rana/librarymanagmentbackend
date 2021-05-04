package com.cognizant.Library.Managment.Controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Library.Managment.Repository.UserRepository;
import com.cognizant.Library.Managment.model.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("authenticate")
public class AuthenticationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		System.out.println("\n\t\tIn Authenticate");
		String user = getUser(authHeader);
		System.out.println("Auth Header  : " + authHeader);
		System.out.println("User : " + user.toString());
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Map<String, String> auth = new HashMap<String, String>();
		System.out.println("just");
		System.out.println( "dfs"+SecurityContextHolder.getContext().getAuthentication());
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(email);
		User currentUser = userRepository.findByEmail(email);

		
		auth.put("token", generateJwt(user));
		
		auth.put("role", role);
		auth.put("username", (currentUser.getName()));
		return auth;
	}

	private String getUser(String authHeader) {
		byte[] auth = Base64.getDecoder().decode(authHeader.split(" ")[1]);
		String authString = new String(auth);
		System.out.println("Auth String " + authString);
		return authString.split(":")[0];
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretKey");
		String token = builder.compact();
		return token;
	}
}

