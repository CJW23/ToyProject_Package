package com.cjw.security.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void index_anonymous() throws Exception {
        mockMvc.perform(get("/").with(anonymous())) //로그인 하지 않은 사용자
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "cjw", roles = "USER")
    public void index_user() throws Exception {
        //.with(user("cjw").roles("USER")) -> 어노테이션으로 해결
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void admin_user() throws Exception {
        mockMvc.perform(get("/admin").with(user("cjw").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}
