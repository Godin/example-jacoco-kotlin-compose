plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
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
    implementation("org.jetbrains.compose.ui:ui-tooling-preview:1.6.10")
    testImplementation(compose.desktop.uiTestJUnit4)
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
}
