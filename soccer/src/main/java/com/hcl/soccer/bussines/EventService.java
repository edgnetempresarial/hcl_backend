package com.hcl.soccer.bussines;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.soccer.dao.IEventDao;
import com.hcl.soccer.entities.EventMessages;

@Service
public class EventService implements IEventService {
	@Autowired
	IEventDao eventDao;

	@Override
	public List<Map<String, Object>> findEventMessages(int id) {
		return eventDao.findEventMessages( id);
	}

	@Override
	public int addEventMessage(int eventId, int userId, String message) {
		
		return eventDao.addEventMessage(eventId, userId, message);
	}

	@Override
	public List<Map<String, Object>> getEventMembers(int id) {
		
		return eventDao.findEventMembers(id);
	}

	@Override
	public List<Map<String, Object>> findEventsElsewhere(int state) {
		
		return eventDao.findEventsElsewhere(state);
	}

	@Override
	public void getEvents() {
		System.out.println(eventDao.allEvents());
	}
}
