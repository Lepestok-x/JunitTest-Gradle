package test_buttons;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Button")
@DisplayName("Test buttons")
public class Buttons {
    private WebDriver driver;
    @BeforeEach
    void initDriver() {
        this.driver = new ChromeDriver();
        this.driver.get("https://demoqa.com/buttons");
    }

    @ParameterizedTest
    @MethodSource("test_buttons.Actual#actual")
    void testButtons(String dMes, String rMes, String cMes) {
        ButtonSubsidiary button = new ButtonSubsidiary(driver);
        button.clickButton(Button.DOUBLE);
        String doubleClickExpected = button.message(Button.DOUBLE);
        assertEquals(dMes, doubleClickExpected);
        button.clickButton(Button.RIGHT);
        String rightClickExpected = button.message(Button.RIGHT);
        assertEquals(rMes, rightClickExpected);
        button.clickButton(Button.CLICK);
        String clickExpected = button.message(Button.CLICK);
        assertEquals(cMes, clickExpected);
    }
    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
