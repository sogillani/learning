package com.sog.spring.security.learnspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class AppController {

    @GetMapping(path = "login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(path = "courses")
    public String getCourses() {
        return "courses";
    }
}
