plugins {
    kotlin("jvm") version "1.9.25"
    id("me.champeau.jmh") version "0.7.2"
}

group = "org.wrongwrong"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        setUrl("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    jmhImplementation(kotlin("reflect"))
    jmhImplementation("com.fasterxml.jackson.core:jackson-databind:2.19.0-SNAPSHOT")
    jmhImplementation(files("./jars/jackson-module-kotlin-2.19.0-f4a544.jar"))
    // jmhImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.0-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}

jmh {
    warmupForks = 2
    warmupBatchSize = 3
    warmupIterations = 3
    warmup = "1s"

    fork = 2
    batchSize = 3
    iterations = 2
    timeOnIteration = "1500ms"

    failOnError = true

    resultFormat = "CSV"
}
