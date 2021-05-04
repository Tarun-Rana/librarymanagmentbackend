package com.cognizant.Library.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Library.Managment.model.CartItems;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Long> {

	
}
