package com.cjw.inflearntest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Mock Stubbing
 */
@ExtendWith(MockitoExtension.class)
class StudyTest2_4 {

    @Test
    void mockTest(@Mock Study study) {
        int test = 3;
        when(study.getLimit()).thenReturn(test);
        assertEquals(study.getLimit(), test, "틀림");

        when(study.test(anyString())).thenReturn("아무거나");
        assertEquals(study.test("aa"), "아무거나");
    }
}