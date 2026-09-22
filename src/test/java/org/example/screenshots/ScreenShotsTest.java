package org.example.screenshots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ScreenShotsTest {
    private String testName;
    @BeforeEach
    void initTestName(TestInfo info) {
        testName = info.getTestMethod().get().getName();
    }
    @Test
    void web1080Test() {
        System.out.println(testName);
    }
}
