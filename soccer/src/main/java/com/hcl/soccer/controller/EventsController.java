package com.hcl.soccer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.soccer.bussines.IEventService;
import com.hcl.soccer.entities.Event;
import com.hcl.soccer.entities.EventMessages;
import com.hcl.soccer.repository.EventMessagesRepository;
import com.hcl.soccer.repository.EventRepository;

@RestController
public class EventsController {
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventMessagesRepository eventMessagesRepository;
	
	@Autowired
	IEventService eventService;
	
	@GetMapping("/allevents/{state}")
	public List<Event> allEvents(@PathVariable("state") int state){
		return eventRepository.findByStateId(state);
	}
	@GetMapping("/alleventsoff/{state}")
	public List<Event> allEventsOff(@PathVariable("state") int state){
		return eventRepository.findByOtherState(state); 
	}
	
	@GetMapping("/event/{id}")
	public Event getEvent(@PathVariable("id") int id){
		return eventRepository.findById(id).get();
	}
	
	@PostMapping("/addevent")
	public Event addEvent(@RequestBody Event evt) {
		Event evt2 = eventRepository.saveAndFlush(evt);
		return evt2;
	}
	@PostMapping("/delevent")
	public void addEvent(@RequestBody int id) {
		eventRepository.delete(new Event(id));
		
	}
	
	@GetMapping("/eventMessages/{id}")
	public List<Map<String, Object>> getEventMessages( @PathVariable("id")int id){
		return eventService.findEventMessages(id);
	}
	@GetMapping("/eventMessages2/{id}")
	public List<EventMessages> getEventMessages2( @PathVariable("id")int id){
		return eventRepository.findById(id).get().getMessages();
	}
	
	@GetMapping("/allEventMessages")
	public List<EventMessages> allEventMessages(){
		return eventMessagesRepository.findAll();
	}
	
	@GetMapping("/eventMembers/{id}")
	public List<Map<String, Object>> getEventMembers( @PathVariable("id") int id){
		
		return eventService.getEventMembers(id);
	}
	
	@PostMapping("/addEventMessage/{eventId}/{userId}")
	public long addMessage(@PathVariable("eventId")int eventId,
			@PathVariable("userId")int userId,
			@RequestBody String message) {
		eventService.addEventMessage(eventId, userId, message);
		return eventMessagesRepository.count();
	}
}
