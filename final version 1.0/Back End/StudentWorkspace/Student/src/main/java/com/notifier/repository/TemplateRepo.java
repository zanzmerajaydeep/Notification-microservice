package com.notifier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.notifier.model.Template;

@Repository
public interface TemplateRepo extends MongoRepository<Template, String> {

}
