package com.cjw.security.account;

import com.cjw.security.entity.Account;
import com.cjw.security.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountService accountService;

    /**
     * 로그인 하지 않은 사용자 테스트
     * @throws Exception
     */
    @Test
    public void index_anonymous() throws Exception {
        mockMvc.perform(get("/").with(anonymous())) //로그인 하지 않은 사용자
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * USER 권한 테스트
     * @throws Exception
     */
    @Test
    @WithMockUser(username = "cjw", roles = "USER")
    public void index_user() throws Exception {
        //.with(user("cjw").roles("USER")) -> 어노테이션으로 해결
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * ADMIN 권한 테스트
     * @throws Exception
     */
    @Test
    public void admin_user() throws Exception {
        mockMvc.perform(get("/admin").with(user("cjw").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    /**
     * 로그인 성공 테스트
     * @throws Exception
     */
    @Test
    @Transactional  //테스트 메소드 실행후 롤백
    public void login_success() throws Exception {
        Account user = this.createUser("a", "a");
        mockMvc.perform(formLogin().user(user.getUsername()).password("a"))
                .andExpect(authenticated());
    }

    /**
     * 로그인 실패 테스트
     * @throws Exception
     */
    @Test
    @Transactional
    public void login_fail() throws Exception {
        Account user = this.createUser("a", "a");
        mockMvc.perform(formLogin().user(user.getUsername()).password("ab"))
                .andExpect(unauthenticated());
    }

    private Account createUser(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("ADMIN");
        return accountService.createNew(account);
    }
}
