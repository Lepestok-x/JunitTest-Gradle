package org.example;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.time.Instant;

import static io.restassured.RestAssured.given;

public abstract class StoreParent {
    protected String path;
    protected String parameter;
    protected int id;
    protected int petId;
    protected int quantity;
    protected Instant shipDate;
    protected String status;
    protected boolean complete;
    protected Object body;
    protected int code;
    private final ThreadLocal<RequestSpecification> specification = ThreadLocal.withInitial(() ->
        new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io")
            .setBasePath("/v2")
            .setContentType("application/json")
            .addHeader("Accept", "application/json")
            .build());
    protected void get() {
        given()
            .spec(specification.get())
            .contentType("application/json")
            .get(path)
            .then()
            .statusCode(code)
            .log().all();
    }
    protected <T> T post(T body, Class<T> clazz) {
        return given()
            .spec(specification.get())
            .body(body)
            .when()
            .post(path)
            .then()
            .log().all()
            .statusCode(code)
            .extract()
            .response()
            .as(clazz);
    }
}
