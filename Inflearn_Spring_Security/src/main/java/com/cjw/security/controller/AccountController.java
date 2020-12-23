package com.cjw.security.controller;

import com.cjw.security.entity.Account;
import com.cjw.security.repository.AccountRepository;
import com.cjw.security.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor        //final, @NonNull 필드에 대한 생성자를 생성
public class AccountController {
    private final AccountService service;

    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(Account account) {
        return service.createNew(account);
    }
}
