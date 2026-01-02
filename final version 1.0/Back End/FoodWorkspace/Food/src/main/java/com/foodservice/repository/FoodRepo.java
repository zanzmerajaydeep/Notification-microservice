package com.foodservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.foodservice.model.Food;

public interface FoodRepo extends MongoRepository<Food, String>{

	Food findByCustomerName(String pndata);
	//public Food findByCustomerName(String customerName);
}
