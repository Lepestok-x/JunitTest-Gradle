package com.example;
import com.example.configurations.Configuration;
import com.example.configurations.ManagerDriver;
import com.example.configurations.types.Value;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag("BUTTONS-N1")
@DisplayName("Открываем сайт demosite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Buttons {
    private final Logger logger = LoggerFactory.getLogger(Buttons.class);
    @RegisterExtension
    final ManagerDriver managerDriver = new ManagerDriver();

    @ParameterizedTest
    @DisplayName("Выполняем нажатие кнопок")
    @MethodSource("com.example.configurations.Configuration#outputConfiguration")
    void clickButtons(Configuration configuration) {
        // Type driver - chrome
        WebDriver driver = managerDriver.getDriver();
        driver.get(configuration.getUri());
        // Я не использую список, та как я проверяю самостоятельность теста: (Но жетально), но читаемо!
        String formated = configuration.actualButton("doubleClickBtn", null);
        this.clickButtonValue(managerDriver.getWebDriverWait(), formated, Value.DOUBLE_CLICK);
        String result_a = this.getResult(managerDriver.getWebDriverWait(), configuration.getIdxPath("doubleClickMessage"));
        String formated_2 = configuration.actualButton("rightClickBtn", null);
        this.clickButtonValue(managerDriver.getWebDriverWait(), formated_2, Value.RIGHT_CLICK);
        String result_b = this.getResult(managerDriver.getWebDriverWait(), configuration.getIdxPath("rightClickMessage"));
        String formated_3 = configuration.actualButton("text", "Click Me");
        this.clickButtonValue(managerDriver.getWebDriverWait(), formated_3, Value.CLICK_ME);
        String result_g = this.getResult(managerDriver.getWebDriverWait(), configuration.getIdxPath("dynamicClickMessage"));

        // Проверяем значении на истину!
        String actual = configuration.getResult("result-1");
        Assertions.assertEquals(result_a, actual, "Поле значений не совпадают - {A}");
        actual = configuration.getResult("result-2");
        Assertions.assertEquals(result_b,  actual, "Поле значений не совпадают - {B}");
        actual = configuration.getResult("result-3");
        Assertions.assertEquals(result_g,  actual, "Поле значений не совпадают - {G}");

    }
    @Step("Нажимаем на кнопку - {2}")
    void clickButtonValue(WebDriverWait webDriverWait, String value, Value type){
       if(value.isBlank() || type.getValue().isBlank()){
           Assertions.fail("Value not found");
           Assertions.fail("Type not found");
           return;
       }
        switch (type) {
            case Value.DOUBLE_CLICK -> {
                WebElement button = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                Actions actions = managerDriver.getActions();
                actions.doubleClick(button).perform();
            }
            case Value.RIGHT_CLICK -> {
                WebElement button = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
                Actions actions = managerDriver.getActions();
                actions.contextClick(button).perform();
            }
            case Value.CLICK_ME -> webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(value))).click();
            default -> logger.warn("Unsupported type: {}", type);
        }
    }
    @Step("Получаем резльтат, после нажатия: {1}")
    public String getResult(WebDriverWait webDriverWait, String id) {
        if(id.isBlank()) Assertions.fail("id is blank");
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id))).getText();
    }
}
