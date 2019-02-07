package com.hcl.soccer.dao;

import java.util.List;
import java.util.Map;

public interface IEventDao {

	List<Map<String, Object>> findEventMessages(int id);

	int addEventMessage(int eventId, int userId, String message);

	List<Map<String, Object>> findEventMembers(int id);

	List<Map<String, Object>> findEventsElsewhere(int state);

	List<Map<String, Object>> allEvents();

}
