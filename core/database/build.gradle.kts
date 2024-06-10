plugins {
  alias(libs.plugins.androidtemplate.android.library)
  alias(libs.plugins.androidtemplate.hilt)
  alias(libs.plugins.androidx.room)
}

android {
  namespace = "com.matrix159.androidtemplate.core.database"
}

room {
  schemaDirectory("$projectDir/schemas")
}

dependencies {
  implementation(libs.roomdb.runtime)
  annotationProcessor(libs.roomdb.compiler)
  ksp(libs.roomdb.compiler)
  implementation(libs.roomdb.ktx)
}