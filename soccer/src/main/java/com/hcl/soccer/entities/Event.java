package com.hcl.soccer.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event implements Serializable {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO) private int id;
	private String name;
	private Date date;
	private String location;
	@OneToOne @JoinColumn(name="state_id")private State state;
	@Column(name="state_id", updatable=false , insertable=false) private int stateId;
	@OneToOne @JoinColumn(name="host_id")private User host;
	@Column(name="host_id", updatable=false , insertable=false)private String hostId;
	private String status;
	
	@OneToMany(fetch=FetchType.LAZY) @JoinColumn(name="EVENT_ID")
	private List<EventMessages> messages;
	
	
	public Event() {
		
	}
	public Event(int id) {
		this.id =id;
	}
	
	
	public List<EventMessages> getMessages(){
		return this.messages;
	}
	
	public void setMessages(List<EventMessages> messages) {
		this.messages = messages;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
