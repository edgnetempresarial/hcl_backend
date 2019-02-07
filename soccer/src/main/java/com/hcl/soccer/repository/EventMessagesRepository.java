package com.hcl.soccer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.soccer.entities.EventMessages;

public interface EventMessagesRepository extends JpaRepository<EventMessages,Integer>{
	List<EventMessages> findByEventId(int eventId);
}
