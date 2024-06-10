package com.matrix159.androidtemplate.ui.theme

import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@PreviewLightDark
@DevicePreviews
@PreviewFontScale
annotation class AndroidTemplatePreviews

/**
 * Multipreview annotation that represents various device sizes. Add this annotation to a composable
 * to render various devices.
 */
@Preview(name = "Phone", device = Devices.PHONE)
@Preview(name = "Phone - Landscape", device = "spec:width = 411dp, height = 891dp, orientation = landscape, dpi = 420")
@Preview(name = "Unfolded Foldable", device = Devices.FOLDABLE)
@Preview(name = "Tablet", device = Devices.TABLET)
@Preview(name = "Desktop", device = Devices.DESKTOP)
annotation class DevicePreviews

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun currentWindowAdaptiveInfo(): WindowSizeClass {
  val configuration = LocalConfiguration.current
  val size = DpSize(configuration.screenWidthDp.dp, configuration.screenHeightDp.dp)
  return WindowSizeClass.calculateFromSize(size)
}

@Composable
fun AndroidTemplatePreviews(content: @Composable () -> Unit) {
  AndroidTemplateTheme {
    Surface {
      content()
    }
  }
}
