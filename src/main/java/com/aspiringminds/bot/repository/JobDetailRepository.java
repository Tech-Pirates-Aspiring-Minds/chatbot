package com.aspiringminds.bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aspiringminds.bot.model.JobDetail;

@Repository
public interface JobDetailRepository extends MongoRepository<JobDetail, Integer> {

}