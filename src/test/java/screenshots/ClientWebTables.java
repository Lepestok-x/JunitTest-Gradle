package screenshots;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ClientWebTables extends WebTablesParent {
    private final Logger logger = LoggerFactory.getLogger(ClientWebTables.class);
    private final ListBy listBy;

    public ClientWebTables(WebDriver driver, ListBy listBy) {
        super(driver);
        this.listBy = listBy;
    }

    @Step("Записано: {1}")
    public void writeField(int step, Supplier<String[]> supplierData) {
        if (step <= 0) throw new RuntimeException("Error step - " + step + ", must step to: 1");
        for (int i = 1; i <= step; i++) {
            String[] fields = supplierData.get();
            button(listBy.getAddButton());
            IntStream.range(0, listBy.getByLocators().size()).forEach(index -> {
                By locator = listBy.getByLocators().get(index);
                logger.info("write: {}", fields[index]);
                writeData(locator, fields[index]);
            });
            button(listBy.getSubmitButton());
            if (fields.length < listBy.getByLocators().size()) {
                throw new IllegalArgumentException(String.format("Не достаточно данных - locator: %s and fields: %s",
                    listBy.getByLocators().size(), fields.length));
            }
        }

    }
}
