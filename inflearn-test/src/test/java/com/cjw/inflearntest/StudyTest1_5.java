package com.cjw.inflearntest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUni5 Assertion
 */
class StudyTest1_5 {
    @Test
    @DisplayName("스터티 만들기")
    void create_new_study() {
        Study study = new Study(1);
        assertNotNull(study);
        //왼쪽 인자가 기댓값, 오른쪽 비교값
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> {
            return study.getStatus() + "는 틀리다";
        });
        assertTrue(() -> {
            return study.getLimit() > 0;
        }, () -> {
            String str = "는 0보다 작다";
            return study.getLimit() + str;
        });
    }

    @Test
    @DisplayName("스터티 다시 만들기")
    void create_new_study_again() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Study(-1);
        });
        assertEquals("0보다 작음", exception.getMessage());

    }

    @Test
    void timeout_test() {
        //실행시간동안 기다림
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(1000);
        }, "시간이 넘음");
        //테스트 시간보다 넘으면 바로 종료
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(10000);
        });
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