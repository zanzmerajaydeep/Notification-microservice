package com.hospital.service;

import java.util.List;

import com.hospital.model.Template;



public interface TemplateService {

	public Template addtemplate(Template template);
	
	public List<Template> getAll();
}
