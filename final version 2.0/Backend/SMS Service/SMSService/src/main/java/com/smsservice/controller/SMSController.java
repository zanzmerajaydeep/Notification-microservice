package com.smsservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smsservice.service.SMSService;

@RestController
@RequestMapping("/sms")
public class SMSController {

	@Autowired
	SMSService smsservice;

	@GetMapping("/home")
	public String getHome() {
		return "Home sms service....";
	}

	@PostMapping(value = "/sendsms")
	public ResponseEntity<String> sendSMS(@RequestBody Map<String, Object> smsData) {

		String Contact = (String) smsData.get("smsto");

		try {

			smsservice.sendSMS(smsData);
			return ResponseEntity.status(HttpStatus.OK).body("SMS sent successfully to: " + Contact);

		} catch (MailException exc) {
			// Handle MailException
			exc.printStackTrace();
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
					.body("{\"error\": \"Failed to send SMS " + Contact);
		} catch (Exception exc) {
			// Handle all other exceptions
			exc.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"error\": \"Failed to send sms " + Contact);
		}

	}
}
