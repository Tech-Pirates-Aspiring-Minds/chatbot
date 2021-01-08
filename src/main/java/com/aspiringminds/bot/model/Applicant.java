package com.aspiringminds.bot.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "applicants")
public class Applicant {
	@Id
	private String applicantId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String jobId;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date appliedDate=new Date();
	private String applicantStatus;
	private String remarks1;
	private String remarks2;
	private String remarks3;
	private File resume;
	@DBRef(lazy = false)
	private JobDetail jobDetail;
	
	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(String applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

	public String getRemarks3() {
		return remarks3;
	}

	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}
	
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-mm-dd");
		return "Applicant Id: "+applicantId+"<br>"+
				"Applicant Name: "+firstName+" "+lastName+"<br>"+
				"Applied for: "+(jobDetail!=null?jobDetail.getJobName():"")+"<br>"+
				"Applied Date: "+sdf.format(appliedDate)+"<br>"+
				"Application status: "+applicantStatus+"<br>"+
				"For more details please email us on hr@aspiringminds.com";
	}

}
