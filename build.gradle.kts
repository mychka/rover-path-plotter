plugins {
    java
}

group = "com.skynet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:6.14.3")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useTestNG()
}

tasks.jar {
    manifest {
        // Make jar runnable.
        attributes["Main-Class"] = "com.skynet.RoverPathPlotter"
    }
}
