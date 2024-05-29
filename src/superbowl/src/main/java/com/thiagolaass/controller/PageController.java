package com.thiagolaass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/verify")
    public String verify() {
        return "index";
    }
}