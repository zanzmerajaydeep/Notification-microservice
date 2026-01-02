package com.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Templates")
public class Template {
	
	private String id;
	private String name;
	private String subject;
	private String body;
	
	public Template() {
		super();
	}
	public Template(String id, String name, String subject, String body) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.body = body;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Template [id=" + id + ", name=" + name + ", subject=" + subject + ", body=" + body + "]";
	}
	
}
