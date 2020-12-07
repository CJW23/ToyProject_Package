package com.cjw.inflearntest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//클래스의 모든 메소드에 적용
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest1_4 {

    @Test
    @DisplayName("스터티 만들기")
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName("스터티 다시 만들기")
    void create_new_study_again() {
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