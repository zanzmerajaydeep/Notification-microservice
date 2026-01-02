package com.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.hospital.model.Template;



@Repository
public interface TemplateRepo extends MongoRepository<Template, String> {

}
