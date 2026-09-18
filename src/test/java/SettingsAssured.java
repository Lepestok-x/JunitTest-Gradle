package org.example;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;

/// Settings assured
/// ThreadLocal<?> specification
/// ThreadLocal<?> fakers
public class SettingsAssured {
    public ThreadLocal<RequestSpecification> specification = ThreadLocal.withInitial(() ->
            new RequestSpecBuilder()
                    .setContentType("application/json")
                    .setBaseUri("https://petstore.swagger.io")
                    .setBasePath("/v2")
                    .build());
    public static final ThreadLocal<Faker> fakerThreadLocal = ThreadLocal.withInitial(Faker::new);

    public RequestSpecification specification() {
        return specification.get();
    }
    @AfterEach
    public void clear() {
        fakerThreadLocal.remove();
    }
}
