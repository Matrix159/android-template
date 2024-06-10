import ext.libs
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  commonConfiguration(this)

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  testLogging {
    events = setOf(
      TestLogEvent.FAILED,
    )
    exceptionFormat = TestExceptionFormat.FULL
  }
}

dependencies {
  testImplementation(kotlin("test"))
  "testImplementation"(libs.findLibrary("kotlinx.coroutines.test").get())

  "androidTestImplementation"(libs.findLibrary("androidx.test.ext.junit").get())
  "androidTestImplementation"(libs.findLibrary("kotlinx.coroutines.test").get())
  "androidTestImplementation"(libs.findLibrary("espresso.core").get())
  androidTestImplementation(kotlin("test"))
}