package assured.example.configuration;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
@Getter
@Setter
public class AssuredConfiguration implements BeforeAllCallback {
    @Override
    public void beforeAll(@NonNull ExtensionContext context) throws Exception {
       RestAssured.baseURI = "https://petstore.swagger.io";
       RestAssured.basePath = "/v2";
       RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
