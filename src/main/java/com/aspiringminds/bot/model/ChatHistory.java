package com.aspiringminds.bot.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "chathistory")
public class ChatHistory {

	private String sessionId;
	private String user;
	private String bot;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date currentDate=new Date();
	public ChatHistory(String sessionId, String user, String bot) {
		// TODO Auto-generated constructor stub
		this.sessionId=sessionId;
		this.user=user;
		this.bot=bot;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getBot() {
		return bot;
	}
	public void setBot(String bot) {
		this.bot = bot;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	
}
