plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
    id("jacoco")
}

jacoco {
    toolVersion = "[0.8.13-SNAPSHOT,)"
}

repositories {
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        mavenContent {
            snapshotsOnly()
            includeGroup("org.jacoco")
        }
    }
    google()
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    testImplementation(compose.desktop.uiTestJUnit4)
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
}

tasks.register("javap") {
  doLast {
    decomp(file("build/classes/kotlin/main/org/example"))
  }
}

fun decomp(f: File) {
  f.walk().forEach {
    if (it.extension == "class") {
      val command = listOf("javap", "-c", "-v", "-p", it.path)
      val outputFile = File(it.parentFile, it.nameWithoutExtension + ".javap.txt")
      exec {
        standardOutput = outputFile.outputStream()
        commandLine(command)
      }
    }
  }
}
