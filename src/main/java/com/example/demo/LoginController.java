package com.example.demo;
//import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;

//import repository.UserRepository;


@Controller
public class LoginController {
	@GetMapping("/")
	public String loginUser() {
		return "resultsPage";
	}
}
