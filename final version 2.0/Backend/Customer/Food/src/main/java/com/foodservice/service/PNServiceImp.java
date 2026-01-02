package com.foodservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.model.PNAdmin;
import com.foodservice.repository.PNSAdminRepo;

@Service
public class PNServiceImp implements PNAdminService {

	@Autowired
	PNSAdminRepo adminRepo;
	
	
	@Override
	public PNAdmin addpn(PNAdmin pnAdmin) {
		return adminRepo.save(pnAdmin);
	}

	@Override
	public List<PNAdmin> getAll() {
		return adminRepo.findAll();
	}
	
}
