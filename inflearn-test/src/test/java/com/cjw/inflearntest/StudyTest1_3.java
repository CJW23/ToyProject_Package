package com.cjw.inflearntest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest1_3 {

    @Test//public 안붙여도 됨 junit5부터
    void create() {
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    //@Disabled       //테스트를 돌리지 않을때
    void create1() {
        System.out.println("create1");
    }

    //무조건 static void로 선언
    //테스트 실행되기 전에 한번 실행됨행
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    //무조건 stati void로 선언
    //테스트 모두 끝난후에 한번 실행
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    //각 테스트전에 실행
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    //각 테스트후 실
    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}