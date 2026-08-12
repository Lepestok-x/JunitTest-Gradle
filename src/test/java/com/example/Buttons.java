package com.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Открываем сайт demosite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RadioButton {


    @BeforeAll
    void testAssured() {

    }
    @Test
    void takeUp() {
     open(" ");
    }
}
