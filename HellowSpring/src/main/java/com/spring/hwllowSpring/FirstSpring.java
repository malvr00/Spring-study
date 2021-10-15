package com.spring.hwllowSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class FirstSpring {
	public String retrieveWelcomeMessage() {
		return "Componnet text";		
	}
}