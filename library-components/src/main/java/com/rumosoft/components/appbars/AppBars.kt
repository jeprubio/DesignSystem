package com.rumosoft.components.appbars

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBars(
    onBack: () -> Unit = {},
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopBar(
                "AppBars",
                navigationIconType = NavigationIconBack(onBack)
            )
        },
    ) { contentPadding ->
    Box(
        modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()
            .background(color = Color.LightGray),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                TopBar(
                    apBarText = "Top App Bar",
                )
            }
            item {
                TopBar(
                    apBarText = "App Bar Text",
                    navigationIconType = NavigationIconBack(onIconClicked = {
                        Toast.makeText(context, "back clicked", Toast.LENGTH_SHORT).show()
                    })
                )
            }
            item {
                TopBar(
                    apBarText = "App Bar Text",
                    navigationIconType = NavigationIconMenu(onIconClicked = {
                        Toast.makeText(context, "menu clicked", Toast.LENGTH_SHORT).show()
                    })
                )
            }
            item {
                TopBar(
                    apBarText = "Top App Bar",
                    textCentered = true,
                )
            }
            item {
                TopBar(
                    apBarText = "App Bar Text",
                    textCentered = true,
                    navigationIconType = NavigationIconBack(onIconClicked = {
                        Toast.makeText(context, "back clicked", Toast.LENGTH_SHORT).show()
                    })
                )
            }
            item {
                TopBar(
                    apBarText = "App Bar Text",
                    textCentered = true,
                    navigationIconType = NavigationIconMenu(onIconClicked = {
                        Toast.makeText(context, "menu clicked", Toast.LENGTH_SHORT).show()
                    })
                )
            }
        }
    }
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

