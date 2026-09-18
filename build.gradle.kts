import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Source: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.22.2")
    // Source: https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind
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
}
