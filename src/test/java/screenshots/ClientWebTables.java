package screenshots;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ClientWebTables extends WebTablesParent {
    private final Logger logger = LoggerFactory.getLogger(ClientWebTables.class);
    private final Bys bys;

    public ClientWebTables(WebDriver driver, Bys bys) {
        super(driver);
        this.bys = bys;
    }

    @Step("Записано: {1}")
    public void writeFieldOrdinary(int step, Supplier<String[]> supplierData) {
        if (step <= 0) throw new RuntimeException("Error step - " + step + ", must step to: 1");
        for (int i = 1; i <= step; i++) {
            String[] fields = supplierData.get();
            button(bys.getAddButton());
            IntStream.range(0, bys.getByLocators().size()).forEach(index -> {
                By locator = bys.getByLocators().get(index);
                String field = fields[index];
                logger.info("write: {}", field);
                writeData(locator, field);
            });
            button(bys.getSubmitButton());

            if (fields.length < bys.getByLocators().size()) {
                throw new IllegalArgumentException(String.format("Не достаточно данных - locator: %s and fields: %s",
                    bys.getByLocators().size(), fields.length));
            }
        }
    }

    @Step("Записано: {1}")
    public void writeFieldInfinity(int of, Supplier<String[]> supplierData) {
        if (of <= 0) throw new RuntimeException("Error step - " + of + ", must step to: 1");
        for (int i = 1; i > -1; i++) {
            int count = getOf(bys.getOf());
            if(count >= of) return;
            String[] fields = supplierData.get();
            button(bys.getAddButton());
            IntStream.range(0, bys.getByLocators().size()).forEach(index -> {
                By locator = bys.getByLocators().get(index);
                String field = fields[index];
                logger.info("write: {}", field);
                writeData(locator, field);
            });
            button(bys.getSubmitButton());

            if (fields.length < bys.getByLocators().size()) {
                throw new IllegalArgumentException(String.format("Не достаточно данных - locator: %s and fields: %s",
                    bys.getByLocators().size(), fields.length));
            }
        }
    }

    public void searchInTable(Supplier<List<String>> names) {
        for (int i = 0; i < names.get().size(); i++) {
            String name = names.get().get(i);
            search(bys.getSearch(), name);
        }
    }
    public void clearText() {
        clear(bys.getSearch());
    }
    public void secondary(Button button) {
       switch (button) {
           case First -> buttonSecondary(bys.getFirst());
           case Previous -> buttonSecondary(bys.getPrevious());
           case Next -> {
               int step = getOf(bys.getOf());
               for(int i = 1; i <= step; i++) {
                   buttonSecondary(bys.getNext());
               }
           }
           case Last -> buttonSecondary(bys.getLast());
           default -> throw new IllegalArgumentException("Error button is not found");
       }
    }
}
