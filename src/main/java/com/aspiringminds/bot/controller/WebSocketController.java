package com.aspiringminds.bot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.aspiringminds.bot.service.ChatService;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	@Autowired
	private ChatService chatservice;


	@MessageMapping("/message")
	@SendToUser("/queue/reply")
	public void processMessageFromClient(@Payload String message, Principal principal) throws Exception {
		String response=chatservice.getChatResponse(principal.getName(),message);
		messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", response);
	}
	
	@MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}