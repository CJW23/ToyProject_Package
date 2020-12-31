package com.cjw.security.controller;

import com.cjw.security.config.AccountContext;
import com.cjw.security.repository.AccountRepository;
import com.cjw.security.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class SampleController {
    private final AccountRepository repository;
    private final SampleService service;

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
        AccountContext.setAccount(repository.findByUsername(principal.getName()));
        service.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Admin " + principal.getName());
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("message", "User " + principal.getName());
        return "user";
    }
}
