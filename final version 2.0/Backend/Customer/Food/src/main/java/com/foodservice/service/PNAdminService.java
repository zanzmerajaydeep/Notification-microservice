package com.foodservice.service;

import java.util.List;

import com.foodservice.model.PNAdmin;

public interface PNAdminService {
	public PNAdmin addpn(PNAdmin pnAdmin);

	public List<PNAdmin> getAll();
}
