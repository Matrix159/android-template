plugins {
  alias(libs.plugins.androidtemplate.android.library)
  alias(libs.plugins.androidtemplate.android.compose)
}

android {
  namespace = "com.matrix159.androidtemplate.core.ui"
}

dependencies {
  implementation(platform(libs.compose.bom))
  implementation(libs.core.ktx)
  implementation(libs.compose.lifecycleRuntime)
  implementation(libs.material3)
  implementation(libs.androidx.material3.windowSizeClass)

  implementation(libs.ui.tooling.preview)

  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
}