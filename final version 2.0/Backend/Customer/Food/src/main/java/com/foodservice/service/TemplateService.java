package com.foodservice.service;

import java.util.List;

import com.foodservice.model.Template;

public interface TemplateService {
	public Template addtemplate(Template template);

	public List<Template> getAll();
}
