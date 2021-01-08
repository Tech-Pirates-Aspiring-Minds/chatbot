package com.aspiringminds.bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aspiringminds.bot.model.ChatHistory;
@Repository
public interface ChatHistoryRepository extends MongoRepository<ChatHistory, String> {

}
