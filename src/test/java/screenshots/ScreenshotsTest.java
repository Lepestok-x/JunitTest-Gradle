package screenshots;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Tag("Screen")
public class ScreenshotsTest {
    private static WebDriver driver;
    private final int time = 10;
    private final Duration duration = Duration.ofSeconds(time);
    private static String nameMethod;
    private static File outputFile;
    // Можно было использовать Selenide, но было решено использовать: Selenium
    @BeforeEach
    void latest(TestInfo info) {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(duration);
      driver.manage().timeouts().implicitlyWait(duration);
      driver.get("https://demoqa.com/");
      nameMethod = info.getTestMethod().get().getName();
    }
    @Test
    void web1080pTest() {
        initFolder();
        assetFullScreen();
    }
    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
    @SneakyThrows
    private static void assetFullScreen() {
        Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
            .takeScreenshot(driver);
        File actualScreen = new File(outputFile.getAbsolutePath() + "/" + nameMethod + ".png");
        ImageIO.write(screenshot.getImage(), "png", actualScreen);

        File expectedScreen = new File(String.format("src/test/resources/references/%s.png", nameMethod));
        if(!expectedScreen.exists()) {
            throw new RuntimeException("No references image");
        }
        assertImages(actualScreen, expectedScreen);

    }
    @SneakyThrows
    private static void initFolder() {
        outputFile = new File("build/screenshots");
        if(!outputFile.exists()) {
            boolean created = outputFile.mkdirs();
            if(created) {
                System.out.println("File successfully created");
            } else {
                System.out.println("File not created");
            }
        }
    }
    @SneakyThrows
    private static void assertImages(File actual, File expected) {
        ImageDiff imageDiff = new ImageDiffer()
            .makeDiff(ImageIO.read(actual), ImageIO.read(expected))
            .withDiffSizeTrigger(10);
        if(imageDiff.hasDiff()) {
           BufferedImage bufferedImage = imageDiff.getMarkedImage();
            ByteArrayOutputStream hos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", hos);
            byte[] bytes = hos.toByteArray();
            Allure.getLifecycle().addAttachment("diff", "image/png", "png", bytes);
        }
       assertFalse(imageDiff.hasDiff());
    }
}
