import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "id.medihause"
version = "1.0.1-kc19"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.keycloak:keycloak-services:19.0.2")
    compileOnly("org.keycloak:keycloak-server-spi:19.0.2")
    compileOnly("org.keycloak:keycloak-server-spi-private:19.0.2")
    compileOnly("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

tasks.named<ShadowJar>("shadowJar") {
    dependencies {
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib:1.8.22"))
    }
    archiveFileName.set("keycloak-totp-api.jar")
}
