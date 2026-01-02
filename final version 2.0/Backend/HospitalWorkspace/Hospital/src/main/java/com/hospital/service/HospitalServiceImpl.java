package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Hospital;
import com.hospital.repository.HospitalRepository;
@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hRepo;
	
	@Override
	public List<Hospital> getPatient() {
		
		return hRepo.findAll();
	}

	@Override
	public Hospital addPatient(Hospital hospital) {
		
		return hRepo.save(hospital);
	}

	@Override
	public Hospital getPatientByContactNo(String contactNo) {

		return hRepo.getPatientByContactNo(contactNo);
	}

}
