package screenshots;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@Tag("tables")
@DisplayName("WebTables")
public class WebTables {
    private ListBy listBy;
    private WebDriver driver;
    @BeforeEach
    void init() {
        listBy = new ListBy();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    void webTablesTest() {
        ClientWebTables clientWebTables = new ClientWebTables(driver, listBy);
        clientWebTables.writeField(10, FakerData::arrayData);
    }
    @AfterEach
    void quit() {
        if(driver != null) {
            driver.quit();
        }
    }
}
