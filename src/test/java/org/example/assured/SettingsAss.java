package org.example.assured;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;

/// Settings assured
/// ThreadLocal<?> specification
/// ThreadLocal<?> fakers
public class SettingsAss {
    private final ThreadLocal<RequestSpecification> specification = ThreadLocal.withInitial(() ->
            new RequestSpecBuilder()
                    .setContentType("application/json") // body json
                    .setBaseUri("https://petstore.swagger.io")
                    .setBasePath("/v2")
                    .build());
    private final ThreadLocal<Faker> fakerThreadLocal = ThreadLocal.withInitial(Faker::new);

    public RequestSpecification specification() {
        return specification.get();
    }
    public Faker faker() {
        return fakerThreadLocal.get();
    }
    @AfterEach
    public void clear() {
        fakerThreadLocal.remove();
    }
}
