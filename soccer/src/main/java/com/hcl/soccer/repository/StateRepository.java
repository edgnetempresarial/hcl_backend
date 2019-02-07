package com.hcl.soccer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.soccer.entities.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
