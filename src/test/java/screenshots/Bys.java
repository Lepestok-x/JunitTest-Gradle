package screenshots;

import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class Bys {
    private final List<By> byLocators = new ArrayList<>();
    private static final String xpathInput = "//input[@id='%s']";
    private static final String xpathButton = "//button[@id='%s']";
    private static final String xpathClass = "//button[contains(@class, 'btn-secondary') and text()='%s']";
    private final By addButton = By.xpath(String.format(xpathButton, "addNewRecordButton"));
    private final By submitButton = By.xpath(String.format(xpathButton, "submit"));
    private final By search = By.xpath(String.format(xpathInput, "searchBox"));
    private final By last = By.xpath(String.format(xpathClass, "Las"));
    private final By first = By.xpath(String.format(xpathClass, "First"));
    private final By next = By.xpath(String.format(xpathClass, "Next"));
    private final By previous = By.xpath(String.format(xpathClass, "Previous"));
    private final By of = By.xpath("//strong");
    public Bys() {
        byLocators.add(By.xpath(String.format(xpathInput, "firstName"))); // firstName
        byLocators.add(By.xpath(String.format(xpathInput, "lastName"))); // lastName
        byLocators.add(By.xpath(String.format(xpathInput, "userEmail"))); // Email
        byLocators.add(By.xpath(String.format(xpathInput, "age"))); // Age
        byLocators.add(By.xpath(String.format(xpathInput, "salary"))); // Salary
        byLocators.add(By.xpath(String.format(xpathInput, "department"))); // Department
    }
    public List<By> getByLocators() {
        return Collections.unmodifiableList(byLocators);
    }
}
