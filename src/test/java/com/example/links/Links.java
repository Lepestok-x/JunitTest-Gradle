package com.example.links;

import com.example.links.factory.Expected;
import com.example.links.factory.Link;
import com.example.links.factory.LinkSubsidiary;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

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
        assertLinesMatch(expected.getExpected(), subsidiary.actualResult(), "Error, data did not match");
    }

    @AfterEach
    void quitDriver() {
        if(driver != null) driver.quit();
    }
}
