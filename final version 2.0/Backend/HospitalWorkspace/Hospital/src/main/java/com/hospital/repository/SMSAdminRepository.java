package com.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository
;
import org.springframework.stereotype.Repository;

import com.hospital.model.Hospital;
import com.hospital.model.SMSAdmin;


@Repository
public interface SMSAdminRepository extends MongoRepository<SMSAdmin, String>{

	

}
