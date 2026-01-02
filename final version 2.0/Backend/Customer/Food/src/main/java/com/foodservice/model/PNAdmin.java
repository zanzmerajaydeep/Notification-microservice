package com.foodservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class PNAdmin {
	private String fcm_api;
	private String server_key;
	
	public PNAdmin(String fcm_api, String server_key) {
		super();
		this.fcm_api = fcm_api;
		this.server_key = server_key;
	}
	public String getFcm_api() {
		return fcm_api;
	}
	public void setFcm_api(String fcm_api) {
		this.fcm_api = fcm_api;
	}
	public String getServer_key() {
		return server_key;
	}
	public void setServer_key(String server_key) {
		this.server_key = server_key;
	}
	
	@Override
	public String toString() {
		return "PNAdmin [fcm_api=" + fcm_api + ", server_key=" + server_key + "]";
	}
	
	
	
	
}
