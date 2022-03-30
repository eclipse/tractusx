plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}


dependencies {
    val edcGroup = "org.eclipse.dataspaceconnector"
    val edcVersion = "0.0.1-SNAPSHOT"

    api("$edcGroup:core-boot:$edcVersion")
    api("$edcGroup:core-base:$edcVersion")
    api("$edcGroup:http:$edcVersion")

    api("$edcGroup:filesystem-configuration:$edcVersion")

    api("jakarta.ws.rs:jakarta.ws.rs-api:3.0.0")
}

application {
    mainClass.set("org.eclipse.dataspaceconnector.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    exclude("**/pom.properties", "**/pom.xm")
    mergeServiceFiles()
    archiveFileName.set("edc.jar")
}
