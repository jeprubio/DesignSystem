package com.rumosoft.components.appbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBars() {
    Column(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Color.LightGray)
    ) {
        TopBar(
            apBarText = "Top App Bar",
            modifier = Modifier.padding(16.dp)
        )
        TopBar(
            apBarText = "Top App Bar",
            textCentered = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_7)
@Composable
fun PreviewAppbars() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            AppBars()
        }
    }
}

