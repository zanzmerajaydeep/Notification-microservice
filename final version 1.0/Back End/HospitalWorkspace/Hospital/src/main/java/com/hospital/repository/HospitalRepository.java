package com.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String>{
	
	public Hospital getPatientByContactNo(String  contactNo);

}
