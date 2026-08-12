plugins {
    id("java")
    id("io.qameta.allure") version "4.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
allure {
    version.set("2.36.0")
    adapter {
        aspectjVersion.set("1.9.25.1")
        frameworks {
            junit5 {
                enabled.set(true)
            }
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:6.0.0")
    implementation("com.codeborne:selenide:7.17.0")
    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
    testCompileOnly("org.projectlombok:lombok:1.18.46")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.46")
    implementation("ch.qos.logback:logback-classic:1.6.1")
    implementation("ch.qos.logback:logback-core:1.6.1")
}

tasks.test {
    useJUnitPlatform()
}
