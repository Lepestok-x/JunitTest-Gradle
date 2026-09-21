package org.example.assured;

import org.junit.jupiter.api.*;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("HH-N1")
@DisplayName("Test pets")
public class TestPet {
    private SettingsAss settingsAssured;
    @BeforeEach
    void init() {
        settingsAssured = new SettingsAss();
    }
    @Test
    @DisplayName("Создаем домашние животное")
    void testPet() throws ClassNotFoundException, FileNotFoundException {
       String dog = settingsAssured.faker().dog().name();
       PetDTO expected = new PetDTO(1, dog, "available");
       PetDTO actual = new Body(settingsAssured)
           .body(expected)
           .path("/pet")
           .code(200)
           .put(PetDTO.class);
       Assertions.assertAll("Тест API", () ->
           assertEquals(expected.getId(), actual.getId(), "Данный ид не совпадает с текущим"), () ->
           assertEquals(expected.getName(), actual.getName(), "Имя не совпадает с текущим именем"), () ->
           assertEquals(expected.getStatus(), actual.getStatus(), "Статус не совпадает с текущим"));

        ApiResponse api = new Body(settingsAssured)
                         .path("/pet/{id}/uploadImage")
                         .parameters("id", 1)
                         .imageDog("src/test/resources/image_dogs/dog.jpg")
                         .code(200)
                         .post(ApiResponse.class);
        System.out.println(api.getMessage());
    }
}
