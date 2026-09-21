package org.example.assured;

import java.io.File;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class Body {
    private final SettingsAss settingsAss;
    private File image;
    private Object body;
    private String path, parameter;
    private int code, id;
    public Body(SettingsAss settingsAss) {
        this.settingsAss = settingsAss;
    }
    public <T>Body body(T body) throws ClassNotFoundException {
        // Выбросим исключение, если объект не будет существовать в памяти.
        if(body == null) throw new ClassNotFoundException("Class not found");
        this.body = body;
        return this;
    }
    public Body imageDog(String pathToImage) throws FileNotFoundException {
        if(pathToImage == null) throw new FileNotFoundException("Field not found");
        image = new File(pathToImage);
        return this;
    }
    public Body parameters(String parameter, int id) {
        this.parameter = parameter;
        this.id = id;
        return this;
    }
    public Body path(String path) {
        this.path = path;
        return this;
    }
    public Body code(int code) {
        this.code = code;
        return this;
    }
    public <T> T put(Class<T> clazz) {
        return given()
            .spec(settingsAss.specification())
            .contentType("application/json")
            .body(body)
            .when()
            .put(path)
            .then()
            .statusCode(code)
            .log().all()
            .extract()
            .as(clazz);
    }
    public <T> T post(Class<T> clazz) {
        return given()
            .spec(settingsAss.specification())
            .contentType("multipart/form-data")
            .pathParam(parameter, id)
            .multiPart("file", image)
            .multiPart("additionalMetadata", "My dog")
            .when()
            .post(path)
            .then()
            .log().all().statusCode(code)
            .extract().as(clazz);
    }
}
