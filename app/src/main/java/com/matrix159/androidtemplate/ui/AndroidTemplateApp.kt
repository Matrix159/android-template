package com.matrix159.androidtemplate.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AndroidTemplateApp(
  windowSizeClass: WindowSizeClass,
  modifier: Modifier = Modifier
) {
  val navController = rememberNavController()

  Surface(modifier = modifier.fillMaxSize()) {
    NavHost(
      navController = navController,
      startDestination = "start_route",
      modifier = Modifier.safeDrawingPadding()
    ) {

      composable("start_route") {
        Text("Start route")
      }
    }
  }
}