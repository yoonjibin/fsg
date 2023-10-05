import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("jvm") version PluginVersion.JVM_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersion.JPA_PLUGIN_VERSION
}

group = "team.iwfsg"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Web.SPRING_WEB)
    implementation(Dependencies.Database.SPRING_DATA_JPA)
    implementation(Dependencies.Validation.SPRING_VALIDATION)
    implementation(Dependencies.Kotlin.KOTLIN_REFLECT)
    implementation(Dependencies.Kotlin.KOTLIN_JDK)
    implementation(Dependencies.Jwt.JWT_API)
    implementation(Dependencies.Jwt.JWT_IMPL)
    implementation(Dependencies.Jwt.JWT_JACKSON)
    implementation(Dependencies.Test.MOCKK)
    implementation(Dependencies.Security.SPRING_SECURITY)
    implementation(Dependencies.Database.SPRING_REDIS)
    implementation(Dependencies.Configuration.CONFIGURATION_PROCESSOR)
    implementation(Dependencies.Swagger.OPEN_API)
    runtimeOnly(Dependencies.Database.MYSQL_CONNECTOR)
    testImplementation(Dependencies.Test.SPRING_TEST)
    testImplementation(Dependencies.Test.KOTEST_RUNNER)
    testImplementation(Dependencies.Test.KOTEST_ASSERTIONS)
    testImplementation(Dependencies.Test.KOTEST_EXTENSION)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
