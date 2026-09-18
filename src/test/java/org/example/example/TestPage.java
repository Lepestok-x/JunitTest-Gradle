package org.example.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Tag("BOX-S1")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestPage {
    private WebDriver driver;
    @BeforeAll
    void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }
    @Test
    void testPage() {
            String fullName = TestData.fullName();
            String email = TestData.email();
            String currentAddress = TestData.currentAddress();
            String permanentAddress = TestData.permanentAddress();
            MainBox mainBox = new MainBox(driver)
                    .writeFullName(fullName)
                    .writeEmail(email)
                    .writeCurrentAddress(currentAddress)
                    .writePermanentAddress(permanentAddress)
                    .submit();
            Data data = mainBox.getData();
            Assertions.assertEquals(expected("Name", fullName), data.getName(), "Имя не соответствует по стандарту: name");
            Assertions.assertEquals(expected("Email", email), data.getEmail(), "Почтовый адрес не совпадает, по указанному значению: email");
            Assertions.assertEquals(currentAddress, data.getCur_address(), "Текущий адрес, не совпадает по указанному значению: cur_address");
            Assertions.assertEquals(permanentAddress, data.getPer_address(), "Постоянный адрес не соответствует по указанному стандарту: per_address");
    }
    @AfterAll
    void quitOfInit() {
        if(driver != null) {
            driver.quit();
        }
    }
    public String expected(String field, String data) {
        return String.format("%s:%s", field, data);
    }
}
