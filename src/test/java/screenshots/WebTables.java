package screenshots;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@Tag("Tables")
@DisplayName("WebTables")
public class WebTables {
    private Bys bys;
    private WebDriver driver;
    @BeforeEach
    void init() {
        bys = new Bys();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    void webTablesTest() {
        ClientWebTables clientWebTables = new ClientWebTables(driver, bys);
        clientWebTables.writeFieldInfinity(3, FakerData::arrayData);
        clientWebTables.searchInTable(FakerData::getNames);
        clientWebTables.clearText();
    }
    @AfterEach
    void quit() {
        if(driver != null) {
            driver.quit();
        }
    }
}
