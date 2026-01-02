package com.foodservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.model.Template;
import com.foodservice.repository.TemplateRepo;

@Service
public class TemplateServiceImp implements TemplateService{

	@Autowired
	TemplateRepo tempRepo;
	@Override
	public Template addtemplate(Template template) {
		return tempRepo.save(template);
	}

	@Override
	public List<Template> getAll() {
		return tempRepo.findAll();
	}
	
}
