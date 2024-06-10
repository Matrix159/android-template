plugins {
  alias(libs.plugins.androidtemplate.android.library)
  alias(libs.plugins.androidtemplate.hilt)
  kotlin("plugin.serialization")
}

android {
  namespace = "com.matrix159.androidtemplate.core.network"
}

dependencies {
  implementation(libs.ktor.client.android)
  implementation(libs.ktor.client.content.negotiation)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.client.logging)
  implementation(libs.timber)
}