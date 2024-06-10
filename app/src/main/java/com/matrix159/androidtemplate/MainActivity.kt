package com.matrix159.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.matrix159.androidtemplate.ui.AndroidTemplateApp
import com.matrix159.androidtemplate.ui.theme.AndroidTemplateTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val windowSizeClass = calculateWindowSizeClass(this)
      AndroidTemplateTheme {
        AndroidTemplateApp(
          windowSizeClass = windowSizeClass,
        )
      }
    }
  }
}
