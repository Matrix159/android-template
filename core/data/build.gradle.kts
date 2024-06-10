plugins {
  alias(libs.plugins.androidtemplate.android.library)
  alias(libs.plugins.androidtemplate.hilt)
}

android {
  namespace = "com.matrix159.androidtemplate.core.data"
}

dependencies {
  api(libs.kotlinx.coroutines)
  api(libs.kotlinx.datetime)
  implementation(libs.androidx.datastore)
  implementation(libs.timber)
}