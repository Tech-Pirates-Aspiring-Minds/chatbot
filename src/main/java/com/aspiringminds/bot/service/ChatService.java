package com.aspiringminds.bot.service;

import java.util.HashMap;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspiringminds.bot.model.Applicant;
import com.aspiringminds.bot.model.ChatHistory;
import com.aspiringminds.bot.model.JobDetail;
import com.aspiringminds.bot.repository.ApplicantRepository;
import com.aspiringminds.bot.repository.ChatHistoryRepository;
import com.aspiringminds.bot.repository.JobDetailRepository;

@Service
public class ChatService {

	
	@Autowired
	private Bot bot;
	
	private HashMap<String,Chat> chatInstance=new HashMap<String,Chat>();
    public Chat getChat(Bot bot,String arg) {
    	if(!chatInstance.containsKey(arg)) {
    		chatInstance.put(arg, new Chat(bot,arg));
    	}
        return chatInstance.get(arg);
    }

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	JobDetailRepository jobDetailRepository;
	
	@Autowired
	ChatHistoryRepository chatHistoryRepository;

	public String getChatResponse(String userName, String request) {
		
		Chat chatSession=getChat(bot,userName);
		String response = chatSession.multisentenceRespond(request);
		response = verifyApplicant(request, response);
		saveChathistory(userName,request,response);
		return response;
	}

	private String verifyApplicant(String request, String response) {
		// TODO Auto-generated method stub
		if (response.contains("verifyApplicant")) {
			Applicant applicant = applicantRepository.findByEmail(request);
			if (applicant != null) {
				applicant.setJobDetail(jobDetailRepository.findOne(Integer.parseInt(applicant.getJobId())));
				return applicant.toString();
			} else
				return "Sorry, your email id is not matching. Please enter a valid email id";
		} else {
			return response;
		}

	}

	public Applicant save(Applicant applicant) {
		return this.applicantRepository.save(applicant);
	}

	public JobDetail save(JobDetail jobDetail) {
		return this.jobDetailRepository.save(jobDetail);
	}
	
	public void saveChathistory(String user,String request,String response) {
		ChatHistory history=new ChatHistory(user,request,response);
		this.chatHistoryRepository.save(history);
	}
}
