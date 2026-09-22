package radiobutton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ClientRadio extends RadioParent {
    private final String xpathToElement = "//input[@id='%sRadio']";
    private final By haveSelectedLocator = By.xpath("//span[contains(@class, 'text-success')]");
    public ClientRadio(WebDriver driver) {
        super(driver);
    }
    public void click(String id) {
        By buttonLocator = By.xpath(String.format(xpathToElement, id));
        button(buttonLocator);
    }
    public String expected() {
        return haveSelected(haveSelectedLocator);
    }
    public boolean isActiveButton(String id) {
        By locatorInactive = By.xpath(String.format(xpathToElement, id));
        return isActive(locatorInactive);
    }
}
