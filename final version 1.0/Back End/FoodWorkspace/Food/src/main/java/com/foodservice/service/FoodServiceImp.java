package com.foodservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.model.Food;
import com.foodservice.repository.FoodRepo;

@Service
public class FoodServiceImp implements FoodService{
	
	@Autowired
	FoodRepo foodRepo;

	@Override
	public List<Food> getFood() {
		return foodRepo.findAll();
	}

	@Override
	public Food addPatient(Food food) {
		return foodRepo.save(food);
	}
	
	
}
