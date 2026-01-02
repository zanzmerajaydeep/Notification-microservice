package com.hospital.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Hospital;
import com.hospital.model.SMSAdmin;
import com.hospital.repository.SMSAdminRepository;

@Service
public class SMSServiceImpl implements SMSservice{

	@Autowired
	SMSAdminRepository smsrepo;
	
	@Override
	public SMSAdmin addsms(SMSAdmin smsAdmin) {

		return smsrepo.save(smsAdmin);
	}

	@Override
	public List<SMSAdmin> getAll() {

		return smsrepo.findAll();
	}

	

}
