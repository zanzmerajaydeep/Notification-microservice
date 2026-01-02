package com.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.model.Hospital;


public interface HospitalService {

	public List<Hospital> getPatient();

	public Hospital addPatient(Hospital hospital);
	
	public Hospital getPatientByContactNo(String  contactNo);

}
