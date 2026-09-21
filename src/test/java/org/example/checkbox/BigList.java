package org.example.checkbox;

import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
@Getter
public class BigList {
    private final List<By> switchers = new ArrayList<>();
    private final By check = By.xpath(formatedField("Home", "checkbox"));
    public BigList() {
        switchers.add(By.xpath(formatedField("Home", "switcher")));
        switchers.add(By.xpath(formatedField("Desktop", "switcher")));
        switchers.add(By.xpath(formatedField("Documents", "switcher")));
        switchers.add(By.xpath(formatedField("WorkSpace", "switcher")));
        switchers.add(By.xpath(formatedField("Office", "switcher")));
        switchers.add(By.xpath(formatedField("Downloads", "switcher")));
    }
    public List<By> getSwitchers() {
        return Collections.unmodifiableList(switchers);
    }
    private static String formatedField(String title, String clazz) {
        return String.format("//span[contains(@title, '%s')]/preceding-sibling::span[contains(@class, '%s')]", title, clazz);
    }
}
