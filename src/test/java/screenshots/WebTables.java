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
        clientWebTables.scroll(200);
        clientWebTables.writeFieldInfinity(2, FakerData::arrayData);
        clientWebTables.searchInTable(FakerData::getNames);
        clientWebTables.clearText();
        clientWebTables.secondary(Button.Next);
        clientWebTables.secondary(Button.First);
        clientWebTables.secondary(Button.Last);
        clientWebTables.secondary(Button.Previous);
    }
    @AfterEach
    void quit() {
        if(driver != null) {
            driver.quit();
        }
    }
}
