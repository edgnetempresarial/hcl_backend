package com.hcl.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.soccer.entities.State;
import com.hcl.soccer.repository.StateRepository;

@RestController
public class LocationContronller {

	@Autowired
	StateRepository stateRepository;
	
	@GetMapping("/allstates")
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
}
