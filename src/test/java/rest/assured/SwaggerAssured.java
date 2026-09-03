package rest.assured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import rest.assured.assured.ManagerAssured;
import rest.assured.json.objects.PetsEntity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("RAS-N1")
@DisplayName("Swagger pet")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SwaggerAssured {
     @RegisterExtension
     private final ManagerAssured manager = new ManagerAssured();

     @Test
     @DisplayName("Отправляем тело запроса: [body]")
     void MessageBody() {

         String randomAnimal = this.manager.faker().animal().name();
         PetsEntity petsEntity = PetsEntity.builder()
                 .id(1)
                 .name(randomAnimal)
                 .status("sold")
                 .build();
         given().spec(this.manager.getRequestSpecification())
                 .body(petsEntity)
                 .when()
                 .post("/pet")
                 .then()
                 .body("name", equalTo(randomAnimal))
                 .body("status", equalTo("sold"));
     }

    @Test
    @DisplayName("Тестируем json поверхность")
    void pets() {
     int id = 1;
     given().spec(this.manager.getRequestSpecification())
             .pathParam("id", id)
             .when()
             .get("/pet/{id}")
             .then()
             .body("id", equalTo(id))
             .log().all().assertThat().statusCode(200);
    }
    @Test
    @DisplayName("Ожидаем ошибку, не существующего сценария")
    void notFoundPets() {
        int id = 99999;
        given().spec(this.manager.getRequestSpecification())
                .pathParam("id", id)
                .when().get("/pet/{id}").then()
                .statusCode(404);
    }
}
