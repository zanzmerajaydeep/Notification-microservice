package com.notifier.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("PNAdmin")
public class PNAdmin {
	private String fcm_api;
	private String server_key;
	private String app_token;
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
	public String getApp_token() {
		return app_token;
	}
	public void setApp_token(String app_token) {
		this.app_token = app_token;
	}
	public PNAdmin(String fcm_api, String server_key, String app_token) {
		super();
		this.fcm_api = fcm_api;
		this.server_key = server_key;
		this.app_token = app_token;
	}
	@Override
	public String toString() {
		return "PNAdmin [fcm_api=" + fcm_api + ", server_key=" + server_key + ", app_token=" + app_token + "]";
	}
	public PNAdmin() {
		super();
	}
}
