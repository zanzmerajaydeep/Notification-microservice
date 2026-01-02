package com.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.model.Hospital;
import com.hospital.model.SMSAdmin;



public interface SMSservice {

	public SMSAdmin addsms(SMSAdmin smsAdmin);
	
	public List<SMSAdmin> getAll();
	
	
}
