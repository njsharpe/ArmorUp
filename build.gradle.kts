plugins {
    id("java")
    id("idea")
}

group = "net.njsharpe"
version = "1.0-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand(mapOf("version" to project.version))
    }
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}