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
    private final By linkResponse = By.xpath("//b");
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
            linkResponded(locator);
            String responded = null;
            String value = linkText(locator);
            String status = actualLink(linkResponse);
            System.out.println(status);
            if(value.equals("Moved")) {
                responded = String.format("Link has responded with staus %s and status text %s Permanently", status, value);
                actual.add(responded);
            } else {
                responded = String.format("Link has responded with staus %s and status text %s", status, value);
                actual.add(responded);
            }
        }
        Thread.sleep(500);
    }
    public List<String> actualResult() {
        return Collections.unmodifiableList(actual);
    }
    private String format(String id) {
        if(id == null) return null;
        return String.format(xpath, id);
    }
}
