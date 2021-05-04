package com.cognizant.Library.Managment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.Library.Managment.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
		public User findByUserId(long id);
		
		public User findByEmail(String email);

}
