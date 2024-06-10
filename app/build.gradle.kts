import java.io.FileInputStream
import java.util.Properties

plugins {
  alias(libs.plugins.androidtemplate.android.application)
  alias(libs.plugins.androidtemplate.hilt)
}

android {
  signingConfigs {
    create("release") {
      // Load keystore
      val keystorePropertiesFile = rootProject.file("keystore.properties")
      val keystoreProperties = Properties()
      if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
        storeFile = rootProject.file("keystore")
        storePassword = keystoreProperties.getProperty("storePassword")
        keyAlias = keystoreProperties.getProperty("keyAlias")
        keyPassword = keystoreProperties.getProperty("keyPassword")
      }
    }
  }
  namespace = "com.matrix159.androidtemplate"

  defaultConfig {
    applicationId = "com.matrix159.androidtemplate"
    versionCode = 1
    versionName = "0.0.1"
  }

  buildTypes {
    debug {
      applicationIdSuffix = ".debug"
    }

    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
    }
  }
}



dependencies {
  implementation(projects.core.ui)
  implementation(projects.core.data)

  implementation(libs.androidx.activity.compose)
  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)

  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.compose.lifecycleRuntime)
  implementation(libs.material3)
//  implementation(libs.material3.extendedIcons)

  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.kotlinx.datetime)
  implementation(libs.timber)


  implementation(libs.androidx.material3.windowSizeClass)

  testImplementation(libs.junit)
  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(kotlin("test"))
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  androidTestImplementation(kotlin("test"))
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
}
