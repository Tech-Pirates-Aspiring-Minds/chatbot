package com.aspiringminds.bot;

import org.alicebot.ab.Bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}

	@Bean
	public Bot getBot(@Value(value = "${simplebot.data.dir}") String path,
			@Value(value = "${simplebot.name}") String botname) {
		Bot bot = new Bot(botname, path);
		return bot;

	}

}