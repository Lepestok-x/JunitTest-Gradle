package radiobutton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Radio")
public class RadioButton {
    private WebDriver driver;
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
    }
    @Test
    void testRadioButton() {
        ClientRadio expected = new ClientRadio(driver);
        expected.click("yes");
        String yesActual = expected.expected();
        expected.click("impressive");
        String impressiveActual = expected.expected();
        boolean isActiveActual = expected.isActiveButton("no");
        Two two = new Two(yesActual, impressiveActual, isActiveActual);
        assertAll("Радион тест", () ->
            assertEquals(yesActual, two.getYes(), "Ошибка, значение не совпало - YES"), () ->
            assertEquals(impressiveActual, two.getImp(), "Ошибка, значение не совпало - IMPR"), () ->
            assertFalse(isActiveActual, "Ошибка, кнопка должна быть не активной"));

    }
    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
