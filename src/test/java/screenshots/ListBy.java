package screenshots;

import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class ListBy {
    private final List<By> byLocators = new ArrayList<>();
    private static final String xpathFormat = "//input[@id='%s']";
    private static final String xpathButton = "//button[@id='%s']";
    private final By addButton = By.xpath(String.format(xpathButton, "addNewRecordButton"));
    private final By submitButton = By.xpath(String.format(xpathButton, "submit"));
    public ListBy() {
        byLocators.add(By.xpath(String.format(xpathFormat, "firstName"))); // firstName
        byLocators.add(By.xpath(String.format(xpathFormat, "lastName"))); // lastName
        byLocators.add(By.xpath(String.format(xpathFormat, "userEmail"))); // Email
        byLocators.add(By.xpath(String.format(xpathFormat, "age"))); // Age
        byLocators.add(By.xpath(String.format(xpathFormat, "salary"))); // Salary
        byLocators.add(By.xpath(String.format(xpathFormat, "department"))); // Department
    }
    public List<By> getByLocators() {
        return Collections.unmodifiableList(byLocators);
    }
}
