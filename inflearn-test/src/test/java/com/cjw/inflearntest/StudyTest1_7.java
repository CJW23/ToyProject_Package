package com.cjw.inflearntest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 순서
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)       //순서를 내가 정할 수 있음
class StudyTest1_7 {
    @Test
    @DisplayName("1번째")
    @Order(1)
    void tag1() {
        assertEquals("a", "b", "1번째는 틀림");
    }

    @Test
    @DisplayName("3번째")
    @Order(3)
    void tag2() {
        assertEquals("a", "a", "3번째는 틀림");
    }

    @Test
    @DisplayName("2번째")
    @Order(2)
    void tag3() {
        assertEquals("a", "a", "2번째는 틀림");
    }


}