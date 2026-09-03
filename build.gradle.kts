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

    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("tools.jackson.core:jackson-databind:3.2.2")
    testImplementation("com.fasterxml.jackson.core:jackson-core:2.22.2")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:6.0.0")
    testImplementation("com.codeborne:selenide:7.17.0")
    testImplementation("org.projectlombok:lombok:1.18.46")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.46")
    testImplementation("ch.qos.logback:logback-classic:1.6.1")
    testImplementation("ch.qos.logback:logback-core:1.6.1")

}

tasks.test {
    useJUnitPlatform {
        val tags = System.getProperty("tags")
        if(tags.isNullOrEmpty()) {
            includeTags(tags)
        }
    }
}
