package org.example.example;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    
    public static String fullName() {
        return faker.name().fullName();
    }
    public static String email() {
        return faker.internet().emailAddress();
    }
    public static String currentAddress() {
        return faker.address().fullAddress();
    }
    public static String permanentAddress() {
        return faker.address().fullAddress();
    }
}
