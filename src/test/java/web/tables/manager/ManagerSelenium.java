package web.tables.manager;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.NonNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

@Getter
public class ManagerSelenium implements BeforeAllCallback, AfterAllCallback {
    private static final StatusArguments status = new StatusArguments();
    private final List<String> salarys = List.of("30000", "45000", "25000", "15000", "65000", "100000", "150000");
    private final List<String> departments = List.of("development", "production", "programming", "architect", "diving");
    private static final int time = 10;
    private WebDriver driver;
    private WebDriverWait wait;
    private String xpath;
    private Faker faker;

    @Override
    public void beforeAll(@NonNull ExtensionContext context) throws Exception {
         this.faker = new Faker();
         this.driver = new ChromeDriver();
         this.driver.manage().window().maximize();
         this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
         this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(time));
         status.successfully(faker, driver, wait);
    }

    @Override
    public void afterAll(@NonNull ExtensionContext context) throws Exception {
       if(this.driver != null) {
           status.successfully(driver);
           this.driver.quit();
       }
    }

    public void openUrl(String url) {
        status.status_values(url, "url");
        this.driver.get(url);
    }
    public String searchToId(String tag, String id) {
        status.status_values(tag, id);
        return String.format("//%s[@id='%s']", tag, id);
    }
    public String searchToClass(String tag, String clazz) {
        status.status_values(tag, clazz);
        return String.format("//%s[@class='%s']", tag, clazz);
    }
    public String searchToClass(String tag, String clazz, String text) {
        return String.format("//%s[@class='%s']/button[text(), '%s']", tag, clazz, text);
    }
    public void addTable_b(WebDriverWait wait, String xpath) {
        status.status_values(wait, xpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    public void write_send(WebDriverWait wait, String xpath, String text) {
        status.status_values(wait, xpath, text);
        WebElement write = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        write.sendKeys(text);
    }
    public void write_xpath(String xpath) {
        status.status_values(xpath, "xpath");
        this.xpath = xpath;
    }
    public String randomAge() {
        return String.valueOf((int)(Math.abs(8 + Math.random() * 100)));
    }
    public String randomSalary() {
        int index = salarys.size();
        return salarys.get((int)(Math.random() * index));
    }
    public String randomDepartment() {
        int index = departments.size();
        return departments.get((int)(Math.random() * index));
    }
    public String read_xpath() {
        return this.xpath;
    }
}
