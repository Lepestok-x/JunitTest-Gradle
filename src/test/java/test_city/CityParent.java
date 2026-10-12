package test_city;

import io.restassured.RestAssured;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CityParent implements BeforeAllCallback {

    @Override
    public void beforeAll(@NonNull ExtensionContext context) throws Exception {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/main";
    }
}
