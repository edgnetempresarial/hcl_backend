package com.hcl.soccer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements IEventDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> findEventMessages(int id) {
		return jdbcTemplate.queryForList("select u.first_name, em.message  from event_messages em "
				+ " inner join user u on em.user_id = u.id"
				+ " where event_id = ?" , id);
	}

	@Override
	public int addEventMessage(int eventId, int userId, String message) {
		int i = jdbcTemplate.queryForObject("select max(id) from event_messages", Integer.class)+1;
		return jdbcTemplate.update("insert into event_messages(id,event_id, user_id, message) values(?,?,?,?)",
				i,eventId, userId, message);
	}

	@Override
	public List<Map<String, Object>> findEventMembers(int id) {
		return jdbcTemplate.queryForList("select u.first_name , u.location from event_members em "
				+ " inner join user u on em.user_id = u.id "
				+ " where event_id = ? ", id);
	}

	@Override
	public List<Map<String, Object>> findEventsElsewhere(int state) {
		return jdbcTemplate.queryForList("select e.name, e.date from event e "
				+ " inner join user u on e.host_id = u.id "
				+ " inner join state s on e.state_id = s.id"
				+ " where e.state_id <> ?" , state);
	}

	@Override
	public List<Map<String, Object>> allEvents() {
		return jdbcTemplate.queryForList("select * from event");
	}
	
	
}