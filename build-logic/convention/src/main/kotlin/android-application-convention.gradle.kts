import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  commonConfiguration(this)
  composeConfiguration(this)

  defaultConfig {
    targetSdk = versionCatalog.findVersion("compile-sdk").get().requiredVersion.toInt()
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

kotlin {
  jvmToolchain(17)
}

tasks.withType<Test> {
  testLogging {
    events = setOf(
      TestLogEvent.FAILED,
    )
    exceptionFormat = TestExceptionFormat.FULL
  }
}