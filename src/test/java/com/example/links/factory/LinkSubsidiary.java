package com.example.links.factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkSubsidiary extends LinksParent{
    private final Locator locator = new Locator();
    private final List<String> actual = new ArrayList<>();
    private static final String xpath = "//a[@id='%s']";
    private final By linkHome = By.xpath(format("simpleLink"));
    private final By linkHomeECPGJ = By.xpath(format("dynamicLink"));
    private final By linkResponse = By.xpath("//p[@id='linkResponse']");
    public LinkSubsidiary(WebDriver driver) {
        super(driver);
    }

    public void clickLink(Link link) {
        switch (link) {
            case HOME -> clickLink(linkHome);
            case HOME_ECPGJ -> clickLink(linkHomeECPGJ);
            default -> throw new IllegalArgumentException(String.format("Link not found: %s", link));
        }
    }
    public void removeTab() {
        newTabReturnToCurrent();
    }
    public void clickResponded() throws InterruptedException {
        for(By locator : locator.bys()) {
            if(locator != null) {
                linkResponded(locator);
                actual.add(actualLink(linkResponse));
            }
        }
    }
    public List<String> actualResult() {
        return Collections.unmodifiableList(actual);
    }
    private String format(String id) {
        if(id == null) return null;
        return String.format(xpath, id);
    }
}
