package com.hcl.soccer.bussines;

import java.util.List;
import java.util.Map;

import com.hcl.soccer.entities.Event;
import com.hcl.soccer.entities.EventMessages;

public interface IEventService {

	List<Map<String, Object>> findEventMessages(int id);

	int addEventMessage(int eventId, int userId, String message);

	List<Map<String, Object>> getEventMembers(int id);

	List<Map<String, Object>> findEventsElsewhere(int state);

	void getEvents();

}
