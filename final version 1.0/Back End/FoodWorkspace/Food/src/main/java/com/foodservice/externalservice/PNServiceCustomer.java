package com.foodservice.externalservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.foodservice.model.Customer;
import com.foodservice.model.Food;
import com.foodservice.model.PNAdmin;
import com.foodservice.model.Template;
import com.foodservice.repository.CustomerRepo;
import com.foodservice.repository.FoodRepo;
import com.foodservice.service.FoodService;
import com.foodservice.service.PNAdminService;
import com.foodservice.service.TemplateService;

@Service
public class PNServiceCustomer {
	
	
	@Autowired
	RestTemplate restTemplet;

	@Autowired
	FoodService foodService;

	@Autowired
	PNAdminService pnService;

	@Autowired
	TemplateService tempService;

	@Autowired
	CustomerRepo customerRepo;

	public List<ResponseEntity<String>> callPNService() {
		Map<String, Object> pnData = new HashMap<>();

		List<ResponseEntity<String>> resArray = new ArrayList<>();

		List<Template> t_list = tempService.getAll();

		Template select_template = null;
		for (Template temp : t_list) {
			if (temp.getName().equals("PN Template customer")) {
				select_template = temp;
			}
		}
		List<Customer> customerlist = customerRepo.findAll();
		PNAdmin pa = pnService.getAll().get(0);

		String[] bd = select_template.getBody().split("\\$");
		String[] td =select_template.getTitle().split("\\$");

		String url = "http://localhost:8888/pushnotificationmicrosevice/pushnotification/sendnotification";

		for (Customer customer : customerlist) {
			
			System.out.println("fianl --"+customer);
			String bankName=customer.getBankName();
			String customerName = customer.getCustomerName();
			
			String tempCreditCardNo="****"+customer.getCardNo().substring(customer.getCardNo().length()-4)+" ";
			String creditCardNo = tempCreditCardNo;
			
			String expDate = customer.getExpairyDate();

			String title = td[0]+bankName;
			String body = bd[0] + customerName + bd[1] + creditCardNo + bd[2] + expDate + bd[3];

			String fcm_api = pa.getFcm_api();
			String server_key = pa.getServer_key();
			String app_token = customer.getApptoken();

			pnData.put("title", title);
			pnData.put("body", body);
			pnData.put("fcm_api", fcm_api);
			pnData.put("server_key", server_key);
			pnData.put("app_token", app_token);
			pnData.put("customerName", customerName);

			System.out.println(pnData);

			try {
				resArray.add(restTemplet.postForEntity(url, pnData, String.class));
			} catch (Exception e) {
				e.printStackTrace();
				resArray.add(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()));
			}
		}

		return resArray;

	}

	public ResponseEntity<String> callPNServiceById(String pndata) {
		Map<String, Object> pnData = new HashMap<>();

		List<Template> t_list = tempService.getAll();

		Template select_template = null;
		for (Template temp : t_list) {
			if (temp.getName().equals("PN Template customer")) {
				select_template = temp;
			}
		}
		   pndata = pndata.replace("\"", "");
		
		Customer customer = customerRepo.findByCustomerName(pndata);
		System.out.println(pndata);
		PNAdmin pa = pnService.getAll().get(0);

		String[] bd = select_template.getBody().split("\\$");
		String[] td =select_template.getTitle().split("\\$");

		String url = "http://localhost:8888/pushnotificationmicrosevice/pushnotification/sendnotification";
         
		String bankName=customer.getBankName();
		String customerName = customer.getCustomerName();
		
		String tempCreditCardNo="****"+customer.getCardNo().substring(customer.getCardNo().length()-4)+" ";
		String creditCardNo = tempCreditCardNo;
		
		String expDate = customer.getExpairyDate();

		String title = td[0]+bankName;
		String body = bd[0] + customerName + bd[1] + creditCardNo + bd[2] + expDate + bd[3];

		String fcm_api = pa.getFcm_api();
		String server_key = pa.getServer_key();
		String app_token = customer.getApptoken();

		pnData.put("title", title);
		pnData.put("body", body);
		pnData.put("fcm_api", fcm_api);
		pnData.put("server_key", server_key);
		pnData.put("app_token", app_token);
		pnData.put("customerName", customerName);
		

		System.out.println(pnData);

		try {
			return restTemplet.postForEntity(url, pnData, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
