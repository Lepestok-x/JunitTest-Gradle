package org.example.checkbox;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@Tag("box-number-1")
@DisplayName("Test tree")
public class CheckBox {
    private final StringBuilder builder = new StringBuilder();
    private WebDriver driver;
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
    }
    @ParameterizedTest
    @DisplayName("Test switchers & checks")
    @MethodSource("org.example.checkbox.ExpectedResult#argumentsStream")
    void test(List<String> list) {
        BigList bigList = new BigList();
        Box actual = new Box(driver, bigList).clickSwitch().clickCheck().closeSwitch()
                .closeCheck().clickSwitch().clickCheck();

        String act = actual.resultBox().replace("You have selected :", "").trim();

        for(String data : list) builder.append(data).append("\n");

        Assertions.assertEquals(builder.toString().trim(), act, "Будущие данные не совпали с ожидающими данными");
    }
    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
