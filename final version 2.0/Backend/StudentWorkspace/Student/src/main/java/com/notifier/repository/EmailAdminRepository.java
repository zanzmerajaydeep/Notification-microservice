package com.notifier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.notifier.model.EmailAdmin;
@Repository
public interface EmailAdminRepository extends MongoRepository<EmailAdmin, String>{

}
