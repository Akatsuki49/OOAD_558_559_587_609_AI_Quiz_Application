package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Feedback1Controller {
	@GetMapping("/feedback")
	public String userFeeback() {
		return "feedback";
	}
}


