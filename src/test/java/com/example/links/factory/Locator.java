package com.example.links.factory;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Locator {
    private final List<By> bys = new ArrayList<>();
    private static final String xpath = "//a[@id='%s']";
    public Locator() {
        bys.add(formatXpath("created"));
        bys.add(formatXpath("no-content"));
        bys.add(formatXpath("moved"));
        bys.add(formatXpath("bad-request"));
        bys.add(formatXpath("unauthorized"));
        bys.add(formatXpath("forbidden"));
        bys.add(formatXpath("invalid-url"));
    }

    public List<By> bys() {
        return Collections.unmodifiableList(bys);
    }

    private By formatXpath(final String id) {
        return By.xpath(String.format(xpath, id));
    }
}
