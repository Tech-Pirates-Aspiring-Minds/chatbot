package com.aspiringminds.bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aspiringminds.bot.model.Applicant;
import com.aspiringminds.bot.model.JobDetail;
import com.aspiringminds.bot.service.ChatService;

@Controller
public class BotController {

	@Autowired
	private ChatService chatservice;

	/*@RequestMapping("/getResponse")
	@ResponseBody
	public String getResponse(@RequestParam(value = "request") String userRequest, Model model) {
		return chatservice.getChatResponse(userRequest);
	}*/

	@PostMapping("/applicants")
	public ResponseEntity<Applicant> createTutorial(@RequestBody Applicant applicant) {
		try {
			Applicant applicantResponse = chatservice.save(applicant);
			return new ResponseEntity<>(applicantResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/jobdetails")
	public ResponseEntity<JobDetail> createTutorial(@RequestBody JobDetail jobDetail) {
		try {
			JobDetail jobDetailResponse = chatservice.save(jobDetail);
			return new ResponseEntity<>(jobDetailResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
