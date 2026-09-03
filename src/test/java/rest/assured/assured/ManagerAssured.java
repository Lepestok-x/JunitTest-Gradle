package rest.assured.assured;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ManagerAssured implements AfterAllCallback {
    private static final ThreadLocal<Faker> faker = ThreadLocal.withInitial(Faker::new);
    private static final ThreadLocal<RequestSpecification> requestSpecification = ThreadLocal.withInitial(() -> new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io")
            .setBasePath("/v2")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build());

    public RequestSpecification getRequestSpecification() {
        return requestSpecification.get();
    }
    public Faker faker() {
        return faker.get();
    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        requestSpecification.remove();
        faker.remove();
    }
}
