plugins {
    `java-library`
}

val javaVersion: String by project

allprojects {
    apply(plugin = "java")

    pluginManager.withPlugin("java-library") {
        group = "org.example"
        version = "1.0-SNAPSHOT"

        dependencies {
            testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
            testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion))
        }
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://maven.iais.fraunhofer.de/artifactory/eis-ids-public/")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
