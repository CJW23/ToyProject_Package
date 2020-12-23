package com.cjw.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Security");
        return "index";
    }
    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "info");
        return "info";
    }
    @GetMapping("/dashboard")
    public String dashbaord(Model model, Principal principal) {
        model.addAttribute("message", principal.getName());
        return "dashboard";
    }
    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Admin " + principal.getName());
        return "admin";
    }
}
