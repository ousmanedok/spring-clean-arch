import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
    kotlin("plugin.jpa") version "1.4.32"
}

group = "com.capstone.server"
//version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
   // implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  //  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  //  implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.rometools:rome:1.16.0")
    implementation("org.jsoup:jsoup:1.14.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
   // testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
//https://docs.spring.io/spring-boot/docs/2.4.5/gradle-plugin/reference/htmlsingle/
tasks.getByName<BootJar>("bootJar") {
    mainClass.set("com.disso.api.ApiGatewayApplicationKt")
    manifest {
        attributes("Start-Class" to "com.capstone.server.CapstoneServerApplicationKt")
    }
   // archiveVersion.set("")
}