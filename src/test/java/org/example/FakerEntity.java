package org.example;

import com.github.javafaker.Faker;

public class FakerEntity {
   private static final Faker faker = new Faker();

   public static int randomId() {
       return faker.random().nextInt(1, 9999);
   }
   public static String status() {
       return faker.name().prefix();
   }
   public static int quantity() {
       return faker.random().nextInt(100, 500);
   }
   public static boolean complete() {
       return faker.random().nextBoolean();
   }
}
