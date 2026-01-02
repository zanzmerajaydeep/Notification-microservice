package com.notifier.externalservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.notifier.model.EmailAdmin;
import com.notifier.model.Student;
import com.notifier.model.Template;
import com.notifier.repository.EmailAdminRepository;
import com.notifier.repository.StudentRepository;
import com.notifier.repository.TemplateRepo;

@Service
public class EmailService {

	@Autowired
	RestTemplate restTemplet;

	@Autowired
	StudentRepository studentrepo;

	@Autowired
	EmailAdminRepository emailadminrepo;

	@Autowired
	TemplateRepo tempRepo;

	public ResponseEntity<String> callGateway() {
		String url = "http://localhost:8888/emailmicroservice/email/home";
		System.out.println("Gateway called");
		return restTemplet.getForEntity(url, String.class);
	}

	@SuppressWarnings("null")
	public List<ResponseEntity<String>> callEmailService() {
		Map<String, Object> emailData = new HashMap<>();

		List<ResponseEntity<String>> resArray = new ArrayList<>();
		List<Template> t_list = tempRepo.findAll();

		List<Student> studentList = studentrepo.findAll();

		EmailAdmin ea = emailadminrepo.findAll().get(0);

		String url = "http://localhost:8888/emailmicroservice/email/sendmail";
		Template select_template = new Template();
		for (Student s : studentList) {
			String name = s.getStudentName();
			int percentage = s.getStudentMark();
			String mentor = s.getStudentMentorName();
			String universityname = s.getStudentUniversity();
			String email = s.getStudentEmail();

			for (Template temp : t_list) {
				if (percentage >= 35 && (temp.getName().equals("Email Template for Pass"))) {
					select_template = temp;
				} else if (percentage < 35 && (temp.getName().equals("Email Template for Fail"))) {
					select_template = temp;
				}
			}

			String subject = select_template.getSubject();
			String[] bd = select_template.getBody().split("\\$");
			String body = bd[0] + name + bd[1] + percentage + "%" + bd[2] + mentor + bd[3] + universityname + bd[4];
			String from = ea.getMailFrom();
			String password = ea.getPassword();
			emailData.put("to", email);
			emailData.put("subject", subject);
			emailData.put("body", body);
			emailData.put("from", from);
			emailData.put("password", password);

			try {
				resArray.add(restTemplet.postForEntity(url, emailData, String.class));
			} catch (Exception e) {
				e.printStackTrace();
				resArray.add(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()));
			}

		}
		return resArray;
	}

	// for
	// ------------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<String> callEmailServiceByEmail(String emailreq) {
		String tempEmail = emailreq.replace("\"", "");
		Map<String, Object> emailData = new HashMap<>();
		String url = "http://localhost:8888/emailmicroservice/email/sendmail";

		List<Template> t_list = tempRepo.findAll();

		List<ResponseEntity<String>> resArray = new ArrayList<>();

		EmailAdmin ea = emailadminrepo.findAll().get(0);

		Student stud = studentrepo.findByStudentEmail(tempEmail);
		System.out.println(stud);

		String name = stud.getStudentName();
		int percentage = stud.getStudentMark();
		String mentor = stud.getStudentMentorName();
		String universityname = stud.getStudentUniversity();
		String email = stud.getStudentEmail();

		Template select_template = null;
		for (Template temp : t_list) {
			if (percentage >= 35 && (temp.getName().equals("Email Template for Pass"))) {
				select_template = temp;
			} else if (percentage < 35 && (temp.getName().equals("Email Template for Fail"))) {
				select_template = temp;
			}
		}
		String[] bd = select_template.getBody().split("\\$");
		String subject = select_template.getSubject();
		String body = bd[0] + name + bd[1] + percentage + "%" + bd[2] + mentor + bd[3] + universityname + bd[4];
		String from = ea.getMailFrom();
		String password = ea.getPassword();
		emailData.put("to", email);
		emailData.put("subject", subject);
		emailData.put("body", body);
		emailData.put("from", from);
		emailData.put("password", password);

		

		try {

			return restTemplet.postForEntity(url, emailData, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
