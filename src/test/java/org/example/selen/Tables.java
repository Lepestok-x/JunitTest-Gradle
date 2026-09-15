package org.example.selen;

import org.example.selen.configuration.ConfigurationMethod;
import org.example.selen.configuration.SettingsFaker;
import org.example.selen.configuration.manager.Manager;
import org.example.selen.types.Type;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("SE-N1")
@DisplayName("Test tables")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tables {
    @RegisterExtension
    static final Manager manager = new Manager();
    static final SettingsFaker faker = new SettingsFaker();

    @BeforeEach
    void openSite() {
        manager.url("https://demoqa.com/webtables");
    }

    @Disabled("Тест не исправен, косяки |ООП|")
    @ParameterizedTest
    @DisplayName("Create user to table")
    @MethodSource("org.example.selen.configuration.ConfigurationMethod#argument")
    void test(ConfigurationMethod method) {
        try {
            for (int i = 1; i > -1; i++) {
                addUserTable(method);
                int of_index = manager.page_of("//strong");
                if (of_index >= 2) {
                    for (int j = 1; j <= of_index; j++) {
                        manager.buttonExecutorJS(method.secondaryButtonText("Next"));
                        Thread.sleep(100);
                    }
                    return;
                }
            }
            // Проверка на отображенных кнопок
            Assertions.assertTrue(manager.isButtonActive(method.searchToClass("btn-group", "Last", Type.CLICK_LAST)), "Кнопка должна быть, активна - Last");
            Assertions.assertTrue(manager.isButtonActive(method.searchToClass("btn-group", "Next", Type.CLICK_NEXT)), "Кнопка должна быть, активна - Next");
            // Проверка на отображенных кнопок
            Assertions.assertTrue(manager.isButtonActive(method.searchToClass("btn-group", "Last", Type.CLICK_PREVIOUS)), "Кнопка должна быть, активной - Previous");
            Assertions.assertFalse(manager.isButtonActive(method.searchToClass("btn-group", "First", Type.CLICK_FIRST)), "Кнопка должна быть, активной - First");
            // Проверка, не отображенных кнопок
            Assertions.assertFalse(manager.isButtonActive(method.searchToClass("btn-group", "First", Type.CLICK_FIRST)), "Кнопка должна быть, не активной - First");
            Assertions.assertFalse(manager.isButtonActive(method.searchToClass("btn-group", "Previous", Type.CLICK_PREVIOUS)), "Кнопка должна быть, не активной - Previous");
            Thread.sleep(8000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void addUserTable(ConfigurationMethod method) {
        manager.button(method.searchToId("button", "addNewRecordButton", Type.ADD));
        manager.writeText(faker.randomFirstName(), method.searchToId("input", "firstName", Type.WRITE_FIRST));
        manager.writeText(faker.randomLastName(), method.searchToId("input", "lastName", Type.WRITE_LAST));
        manager.writeText(faker.randomEmail(), method.searchToId("input", "userEmail", Type.WRITE_EMAIL));
        manager.writeText(faker.randomAge(), method.searchToId("input", "age", Type.WRITE_AGE));
        manager.writeText(faker.randomSalary(), method.searchToId("input", "salary", Type.WRITE_SALARY));
        manager.writeText(faker.randomDepartment(), method.searchToId("input", "department", Type.WRITE_DEPARTMENT));
        manager.button(method.searchToId("button", "submit", Type.SUBMIT));
    }
}
