plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "com.app"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // Kotlin stdlib (já vem implicitamente, mas deixo explícito)
    implementation(kotlin("stdlib"))

    // Testes
    testImplementation(kotlin("test")) // kotlin.test
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("io.mockk:mockk:1.13.17")
    
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.app.MainKt")
}
