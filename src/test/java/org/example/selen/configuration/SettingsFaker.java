package org.example.selen.configuration;

import com.github.javafaker.Faker;

public class SettingsFaker extends Faker {

     public String randomSalary() {
         return String.valueOf(this.random().nextInt(8000, 1_000_000));
     }
     public String randomAge() {
         return String.valueOf(this.random().nextInt(10, 100));
     }
     public String randomDepartment() {
         return this.company().name();
     }
     public String randomEmail() {
         return this.internet().emailAddress();
     }
     public String randomFirstName() {
         return this.name().firstName();
     }
     public String randomLastName() {
         return this.name().lastName();
     }
}
