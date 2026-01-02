package com.foodservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.model.PNAdmin;

@Repository
public interface PNSAdminRepo extends MongoRepository<PNAdmin, String>{
	
}
