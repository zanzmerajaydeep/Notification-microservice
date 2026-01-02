package com.hospital.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("patientData") 
public class Hospital {
	
	private String patientName;
	private String contactNo;
	private String doctorName;
	private String date;
	private String time;
	private String hospitalName;
	public Hospital() {
		super();
	}
	public Hospital(String patientName,String contactNo, String doctorName, String date, String time, String hospitalName) {
		super();
		this.patientName = patientName;
		this.contactNo = contactNo;
		this.doctorName = doctorName;
		this.date = date;
		this.time = time;
		this.hospitalName = hospitalName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Override
	public String toString() {
		return "Hospital [patientName=" + patientName + ", contactNo=" + contactNo + ", doctorName=" + doctorName
				+ ", date=" + date + ", time=" + time + ", hospitalName=" + hospitalName + "]";
	}
	
	
}
