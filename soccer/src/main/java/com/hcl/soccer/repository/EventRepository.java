package com.hcl.soccer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.soccer.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{

	List<Event> findByStateId(int state);

	@Query("select e from Event e where e.stateId != ?1")
	List<Event> findByOtherState(int state);

}
