package com.in28minutes.spring.aop.springaop.data;

import org.springframework.stereotype.Repository;

import com.in28minutes.spring.aop.springaop.aspect.TimeTrack;

@Repository
public class Dao1 {
	
	@TimeTrack
	public String retriveSomething() {
		return "Dao1";
	}

}
