package com.foodservice.service;

import java.util.List;

import com.foodservice.model.Food;

public interface FoodService {
	public List<Food> getFood();

	public Food addPatient(Food food);
}
