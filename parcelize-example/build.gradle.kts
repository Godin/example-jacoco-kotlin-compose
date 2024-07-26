plugins {
  id("com.android.library") version "8.5.0"
  kotlin("android") version "2.0.0"
  kotlin("plugin.parcelize") version "2.0.0"
  id("jacoco")
}

group = "org.example"

repositories {
  mavenCentral()
}

android {
  defaultConfig {
    compileSdk = 33
  }
  namespace = "org.example"

  // https://developer.android.com/build/jdks
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {
  testImplementation(kotlin("test"))
}

tasks.register("jacocoTestReport", JacocoReport::class) {
  dependsOn("testDebugUnitTest")
  classDirectories.setFrom(
    fileTree("$buildDir/tmp/kotlin-classes/debug")
  )
  executionData.setFrom(file("$buildDir/jacoco/testDebugUnitTest.exec"))
  sourceDirectories.setFrom(file("src/main/kotlin"))
}
