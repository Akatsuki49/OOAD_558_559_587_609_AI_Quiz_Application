package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class resultControllerRoute {
    @GetMapping("/results")
    public String userResult() {
        return "resultsPage";
    }
}
