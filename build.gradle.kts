import org.jetbrains.intellij.tasks.PublishTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.3.50"
    id("org.jetbrains.intellij") version "0.4.10"
}

group = "io.github.ajab"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

intellij {
    version = "2019.1"
    pluginName = "Timestamp Generator"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<PublishTask> {
    token(prop("intellijPublishToken") ?: "unknown")
    channels(prop("intellijPublishChannels") ?: "")
}

tasks.create("printVersion") {
    doLast {
        val version: String by project
        println(version)
    }
}

fun prop(name: String): String? =
    extra.properties[name] as? String