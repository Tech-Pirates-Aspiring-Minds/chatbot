package com.aspiringminds.bot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="jobdetail")
public class JobDetail {
	@Id
	private Integer jobId;
	private String jobName;
	private String jobDescription;
	private Integer openPosition;
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Integer getOpenPosition() {
		return openPosition;
	}
	public void setOpenPosition(Integer openPosition) {
		this.openPosition = openPosition;
	}
	
	
	

}
