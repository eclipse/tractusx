plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}


dependencies {
    val edcGroup = "org.eclipse.dataspaceconnector"
    val edcVersion = "0.0.1-SNAPSHOT"

    api("$edcGroup:web-spi:$edcVersion")
    api("$edcGroup:core-base:$edcVersion")
    api("$edcGroup:core-boot:$edcVersion")
    api("$edcGroup:http:$edcVersion")

    api("$edcGroup:data-plane-spi:$edcVersion")
    api("$edcGroup:data-plane-framework:$edcVersion")
    api("$edcGroup:data-plane-http:$edcVersion")
    api("$edcGroup:data-plane-api:$edcVersion")

    api("$edcGroup:observability-api:$edcVersion")

    api("$edcGroup:filesystem-configuration:$edcVersion")
}

application {
    mainClass.set("org.eclipse.dataspaceconnector.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    exclude("**/pom.properties", "**/pom.xm", "jndi.properties", "jetty-dir.css", "META-INF/maven/**")
    mergeServiceFiles()
    archiveFileName.set("edc.jar")
}