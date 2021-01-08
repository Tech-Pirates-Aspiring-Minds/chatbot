package com.aspiringminds.bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aspiringminds.bot.model.Applicant;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, String> {
	Applicant findByEmail(String email);

}