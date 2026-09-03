package assured.example.unploud.file;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Tag("FILE-N1")
@DisplayName("Открываем сайт demosite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImageDownLoadSelenium {
    private final Logger logger = LoggerFactory.getLogger(ImageDownLoadSelenium.class);
    private ChromeOptions options;
    private WebDriverWait webDriverWait;
    private WebDriver driver;
    private String downloadFile = System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloadFile";
    @BeforeAll
    void start() {
       this.driver = new ChromeDriver();
       this.options = new ChromeOptions();
       Map<String, String> prefs = new HashMap<>();
       prefs.put("download.default.directory", downloadFile);
       this.options.setExperimentalOption("prefs", prefs);
       this.driver.manage().window().maximize(); // Window resolutions
       this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    @DisplayName("Открываем файл, для скачивание")
    void openFile() {
        String path = absolutePath("/src/test/resources/asus_image.jpg");
        if(path == null) Assertions.fail("Test failed: " + path);

        try {
            this.driver.get("https://demoqa.com/upload-download");
            WebElement uploadImage = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='uploadFile']")));
            uploadImage.sendKeys(path);
            WebElement getUploadedImage = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='uploadedFilePath']")));
            Assertions.assertTrue(getUploadedImage.getText().contains("asus_image.jpg"), "Error file not found");
            this.driver.navigate().to("https://demoqa.com/radio-button");
            Thread.sleep(8000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
    @Disabled("NaN")
    @Test
    @DisplayName("Download image")
    void testDownloadImage() {
        String path = absolutePath("/src/test/resources/asus_image.jpg");
        if(path == null) Assertions.fail("Test failed: " + path);

        this.driver.get("https://demoqa.com/upload-download");
        WebElement uploadImage = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='uploadFile']")));
        uploadImage.sendKeys(path);

        WebElement downlandImage = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='downloadButton']")));
        downlandImage.click();
    }
    public String absolutePath(String path) {
        return path != null ? System.getProperty("user.dir") + path : null;
    }
    @AfterAll
    void stop() {
        if(this.driver != null) {
            this.driver.quit();
        } else {
            logger.error("It's driver not found: {}", driver);
        }
    }
}
