package web.tables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import web.tables.manager.ManagerSelenium;

@Tag("WEB-N1")
@DisplayName("Тестируем веб таблицы")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebTables {
    @RegisterExtension
    static final ManagerSelenium managerSelenium = new ManagerSelenium();

    @Test
    @DisplayName("Testing tables")
    void testWebTables() {
        managerSelenium.openUrl("https://demoqa.com/webtables");
      try {
          for(int i = 1; i < 10; i++) {
              this.addUserToTable();
          }
          Thread.sleep(3000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
      }
    }
    public void addUserToTable() {
        managerSelenium.write_xpath(managerSelenium.searchToId("button", "addNewRecordButton"));
        managerSelenium.addTable_b(managerSelenium.getWait(), managerSelenium.read_xpath());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "firstName"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.getFaker().name().firstName());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "lastName"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.getFaker().name().lastName());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "userEmail"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.getFaker().internet().emailAddress());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "age"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.randomAge());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "salary"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.randomSalary());
        managerSelenium.write_xpath(managerSelenium.searchToId("input", "department"));
        managerSelenium.write_send(managerSelenium.getWait(), managerSelenium.read_xpath(), managerSelenium.randomDepartment());
        managerSelenium.write_xpath(managerSelenium.searchToId("button", "submit"));
        managerSelenium.addTable_b(managerSelenium.getWait(), managerSelenium.read_xpath());
        managerSelenium.write_xpath(managerSelenium.searchToId("button", "addNewRecordButton"));
        managerSelenium.addTable_b(managerSelenium.getWait(), managerSelenium.read_xpath());
        managerSelenium.write_xpath(managerSelenium.searchToClass("button", "btn-close"));
        managerSelenium.addTable_b(managerSelenium.getWait(), managerSelenium.read_xpath());
    }
}
