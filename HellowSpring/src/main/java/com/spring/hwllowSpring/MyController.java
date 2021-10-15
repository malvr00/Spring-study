package com.spring.hwllowSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController{
	@Autowired
	private FirstSpring service;
	
	@GetMapping("/welcome")
	public String welcome() {
		log.debug("iijii");
		return service.retrieveWelcomeMessage();
	}
}