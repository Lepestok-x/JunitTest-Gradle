package test_city;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(CityParent.class)
@DisplayName("Test city")
public class City {

    @Test
    @DisplayName("City")
    void testCity() {
        CityDTO cityExpected = new CityDTO("Moskow", true);
//        CityDTO cityActual = given()
//            .contentType("application/json")
//            .body(cityExpected)
//            .when()
//            .post("/city/create")
//            .then()
//            .log()
//            .all()
//            .statusCode(201)
//            .extract()
//            .as(CityDTO.class);
//        assertEquals(cityExpected.city(), cityActual.city(), "Город не совпадает!");
//        assertTrue(cityActual.isReal(), "Город должен существовать");


        CityDTO cityActual_2 = given()
            .get("/city/1")
            .then()
            .log()
            .all()
            .statusCode(200)
            .extract()
            .as(CityDTO.class);
        assertNotNull(cityActual_2);
        assertEquals(cityActual_2.city(), cityExpected.city(), "Город не существует");
        assertTrue(cityActual_2.isReal(), "Город должен существовать");
    }
}
