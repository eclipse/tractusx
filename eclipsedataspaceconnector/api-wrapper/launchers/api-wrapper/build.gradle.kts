plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val edcGroup = "org.eclipse.dataspaceconnector"
val edcVersion = "0.0.1-SNAPSHOT"

dependencies {
    api("$edcGroup:core-boot:$edcVersion")
    api("$edcGroup:core-base:$edcVersion")
    api("$edcGroup:http:$edcVersion")

    api("$edcGroup:filesystem-configuration:$edcVersion")

    api("$edcGroup:catalog-spi:$edcVersion")
    api("$edcGroup:contract-spi:$edcVersion")
    api("$edcGroup:transfer-spi:$edcVersion")
    api("$edcGroup:auth-spi:$edcVersion")

    api("jakarta.ws.rs:jakarta.ws.rs-api:3.0.0")
}

application {
    mainClass.set("$edcGroup.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    exclude("**/pom.properties", "**/pom.xm")
    mergeServiceFiles()
    archiveFileName.set("edc.jar")
}
