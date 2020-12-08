package com.cjw.inflearntest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * JUnit5 조건에 따라 테스트 실행하기
 */
class StudyTest1_6 {

    @Test
    void aussme() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        //특정 조건일 때 실행
        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            //테스트
        });

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            //테스트
        });
    }

    @Test
    @EnabledOnOs(OS.MAC) //맥일때 실행
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")    //매치시 실행
    void mac() {
        assertEquals("awd", "awd", "awdawd");
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX}) //맥일때 실행
    //@DisabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.JAVA_8)   //특정 자바 버전
    void window() {
        assertEquals("awd", "awd", "awdawd");
    }
}