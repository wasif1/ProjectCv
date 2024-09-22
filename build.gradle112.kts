plugins {
    id ("org.springframework.boot") version "3.1.2"
    id ("io.spring.dependency-management") version "1.1.2"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"
sourceCompatibility = "17" // Use the JDK version you're working with

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Spring Boot Web dependency for building REST APIs
    implementation 'org.springframework.boot:spring-boot-starter-web'

    // Spring Data JPA for ORM (Object-Relational Mapping)
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    // H2 Database (for in-memory testing, replace with MySQL or PostgreSQL in production)
    runtimeOnly 'com.h2database:h2'

    // Lombok to reduce boilerplate code like getters, setters, and constructors
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'

    // Spring Boot Starter Test (JUnit 5, Mockito)
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

}

tasks.test {
    useJUnitPlatform()
}