package com.example.links;

import com.example.links.factory.Expected;
import com.example.links.factory.Link;
import com.example.links.factory.LinkSubsidiary;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Links")
@DisplayName("Test links")
public class Links {
    private final Expected expected = new Expected();
    private WebDriver driver;
    private static final String currentUrl = "https://demoqa.com/links";
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(currentUrl);
    }
    @Test
    @DisplayName("Click link & result link")
    void testLink() throws InterruptedException {
        LinkSubsidiary subsidiary = new LinkSubsidiary(driver);
        subsidiary.clickLink(Link.HOME);
        subsidiary.clickLink(Link.HOME_ECPGJ);
        subsidiary.removeTab();
        subsidiary.clickResponded();
        assertEquals(expected.getExpected().size(), subsidiary.actualResult().size());
        // Двойная пробежка:) O(n2)
        // Тут ошибка, данные не совпадают, будем фиксить ошибку.
        for(String expectedResult : expected.getExpected()) {
            String expected = expectedResult;
            for(String actualResult : subsidiary.actualResult()) {
                String actual = actualResult;
                assertEquals(expected, actual);
            }
        }
    }

    @AfterEach
    void quitDriver() {
        if(driver != null) driver.quit();
    }
}
