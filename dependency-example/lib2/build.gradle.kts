plugins {
    java
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.example.greeting") version "1.0-SNAPSHOT" //from my-plugin folder
}


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(platform("com.example:bom-project:1.0-SNAPSHOT"))
    implementation(libs.my.lib1)
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
