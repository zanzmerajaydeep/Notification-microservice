package com.foodservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Templates")
public class Template {
	private String name;
	private String title;
	private String body;
	public Template(String name, String title, String body) {
		super();
		this.name = name;
		this.title = title;
		this.body = body;
	}
	public Template() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Template [name=" + name + ", title=" + title + ", body=" + body + "]";
	}
	
}
