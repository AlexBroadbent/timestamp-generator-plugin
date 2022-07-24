import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.intellij.tasks.PublishPluginTask

plugins {
    idea
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.intellij") version "1.7.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "io.github.alexbroadbent"
version = "0.1.5"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-1.2-api:2.17.2")

    testImplementation("io.kotest:kotest-runner-junit5:5.3.0")
}

intellij {
    type.set("IC")
    version.set("2022.1.1")
    downloadSources.set(true)
    pluginName.set("Timestamp Generator")
    updateSinceUntilBuild.set(false)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }

    test {
        useJUnitPlatform()

        testLogging {
            events(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
        }
    }

    patchPluginXml {
        version.set("0.1.5")
        sinceBuild.set("143")
        untilBuild.set("")
    }

    runPluginVerifier {
        ideVersions.set(listOf("2020.3.4", "2021.3.3", "2022.1.2"))
    }

    withType<PublishPluginTask> {
        token.set(prop("intellijPublishToken"))
        channels.set(listOf(prop("intellijPublishChannels")))
    }

    create("printVersion") {
        doLast {
            val version: String by project
            println(version)
        }
    }
}

fun prop(name: String) = extra.properties[name] as? String ?: ""
