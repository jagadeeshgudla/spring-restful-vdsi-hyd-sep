package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class Singer /*implements Performer */{

	// @Autowired
	// Audience audience;
	
	//@Override
	public void performe() {
		// audience.switchedOffMobile();
		// audience.takeSeat();
		System.out.println("Singer is now singing..");
		// audience.applaud();

	}

}
