package assured.example;

import assured.example.configuration.AssuredConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("SWAGGER-N1")
@ExtendWith(AssuredConfiguration.class)
@DisplayName("Обращаемся к сайту swagger")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlatformAssured {

    @Test
    @DisplayName("Получаем данные из swagger")
    void requestValue() {
        int id = 999999999;
        given().pathParam("id", id)
                .when().get("/pet/{id}")
                .then().statusCode(404)
                .body("message", equalTo("Pet not found"));
    }

}
