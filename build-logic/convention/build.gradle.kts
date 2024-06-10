plugins {
  `kotlin-dsl`
}

group = "com.matrix159.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  jvmToolchain(17)
}

dependencies {
  implementation(libs.com.android.gradle.plugin)
  implementation(libs.org.jetbrains.kotlin.android.gradle.plugin)
  implementation(libs.com.google.devtools.ksp.plugin)
  implementation(libs.hilt.gradle.plugin)
  implementation(libs.androidx.room.gradle.plugin)
}