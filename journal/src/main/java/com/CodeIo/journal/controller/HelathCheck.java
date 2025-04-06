package com.CodeIo.journal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelathCheck {
    @GetMapping("/health-check")
    public String helathCheck() {
        return "OK";
    }
}
