package test_buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonSubsidiary extends ButtonsParent{
    private static final String xpathId = "//button[@id='%s']";
    private static final String xpathTag = "//p[@id='%s']";
    private final By doubleClick = By.xpath(String.format(xpathId, "doubleClickBtn"));
    private final By rightClick = By.xpath(String.format(xpathId, "rightClickBtn"));
    private final By click = By.xpath("//button[contains(@class, 'btn btn-primary') and text()='Click Me']");
    private final By doubleMessage = By.xpath(String.format(xpathTag, "doubleClickMessage"));
    private final By rightMessage = By.xpath(String.format(xpathTag, "rightClickMessage"));
    private final By clickMessage = By.xpath(String.format(xpathTag, "dynamicClickMessage"));
    public ButtonSubsidiary(WebDriver driver) {
        super(driver);
    }
    public void clickButton(Button button) {
        By locator = null;
        if(button == Button.DOUBLE) locator = doubleClick;
        if(button == Button.RIGHT) locator = rightClick;
        if(button == Button.CLICK) locator = click;
        button(button, locator);
    }
    public String message(Button butMes) {
        By locator = null;
        if(butMes == Button.DOUBLE) locator = doubleMessage;
        if(butMes == Button.RIGHT) locator = rightMessage;
        if(butMes == Button.CLICK) locator = clickMessage;
        return buttonMessage(locator);
    }
}
