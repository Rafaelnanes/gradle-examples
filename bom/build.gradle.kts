plugins {
    id("java-platform")
    id("maven-publish")
}

group = "com.example"
version = "1.0-SNAPSHOT"

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("com.google.guava:guava:33.4.0-jre")
    }
}

repositories {
    mavenCentral()
}


publishing {
    publications {
        create<MavenPublication>("mavenBOM") {
            from(components["javaPlatform"])
        }
    }
    repositories {
        mavenLocal()
    }
}