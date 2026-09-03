package slider.example;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.manager.selenium.ManagerSelenium;

@Tag("SL-N1")
@DisplayName("Перемещение слайдера")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SliderExample {
    @RegisterExtension
    static final ManagerSelenium managerSelenium = new ManagerSelenium();

    @Test
    @DisplayName("Перемещаем слайдер")
    void testSlider() {
        managerSelenium.OpenURL("https://demoqa.com/slider");
        WebDriverWait wait = managerSelenium.webDriverWait();
        Actions actions = managerSelenium.getActions();
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='range']")));
        slider.click();
        for(int i = 0; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
