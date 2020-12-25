package com.cjw.security.service;

import com.cjw.security.config.AccountContext;
import com.cjw.security.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;

@Service
@Slf4j
public class SampleService {
    public void dashboard() {
        //SecurityContextHolder -> SecurityContext -> Authentication
        /*Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        Object principal = authentication.getPrincipal();   //UserDetails Type
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean authenticated = authentication.isAuthenticated();
        ((UserDetails)principal).getUsername();
        authentication.getAuthorities();
        authentication.getPrincipal();*/
        Account account = AccountContext.getAccount();
        log.info("-------------------");
        log.info(account.getUsername());
        log.info("-------------------");

    }
}
