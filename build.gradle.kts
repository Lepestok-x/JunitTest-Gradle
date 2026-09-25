import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
    id("io.qameta.allure") version "4.3.0"
    id("org.gradle.test-retry") version "1.5.8"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
allure {
    version = "3.14.3"
}

dependencies {
    testImplementation("org.junit-pioneer:junit-pioneer:2.3.0")
    testImplementation("io.qameta.allure:allure-junit5:2.35.5")
    implementation("com.codeborne:selenide:7.18.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.22.2")
    implementation("ru.yandex.qatools.ashot:ashot:1.5.4")
    implementation("tools.jackson.core:jackson-databind:3.2.2")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:6.0.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.48.0")
    implementation("ch.qos.logback:logback-classic:1.6.3")
    implementation("ch.qos.logback:logback-core:1.6.3")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.48")
    testCompileOnly("org.projectlombok:lombok:1.18.48")
}
tasks.test {
    val tags = System.getProperty("tags");
    if(!tags.isNullOrEmpty()) {
        useJUnitPlatform {
            includeTags(tags)
        }
    } else {
        useJUnitPlatform()
    }
    testLogging {
        events("passed", "skipped", "failed");
        showExceptions = true;
        showStackTraces = true;
        showStandardStreams = true;
        exceptionFormat = TestExceptionFormat.FULL;
    }
    maxHeapSize = "2g"
}
