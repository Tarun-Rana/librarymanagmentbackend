package com.cognizant.Library.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Library.Managment.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

	
}
