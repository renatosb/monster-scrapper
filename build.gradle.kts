import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

plugins {
    kotlin("jvm") version "1.9.24"
}

group = "com.app"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

    // 🔴 ESSENCIAL (resolve seu erro)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")

    testImplementation(kotlin("test"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

extensions.configure<KotlinProjectExtension> {
    jvmToolchain(17)
}