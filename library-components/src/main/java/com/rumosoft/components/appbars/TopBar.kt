package com.rumosoft.components.appbars

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    apBarText: String,
    modifier: Modifier = Modifier,
    textCentered: Boolean = false,
    navigationIconType: NavigationIconType = NavigationIconType.None,
) {
    if (textCentered) {
        CenterAlignedTopAppBar(
            title = { Text(text = apBarText) },
            modifier = modifier,
            navigationIcon = {
                NavigationIcon(navigationIconType = navigationIconType)
            }
        )
    } else {
        TopAppBar(
            title = { Text(text = apBarText) },
            modifier = modifier,
            navigationIcon = {
                NavigationIcon(navigationIconType = navigationIconType)
            }
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    MaterialTheme {
        Column {
            TopBar(
                apBarText = "App Bar Text",
            )
            TopBar(
                apBarText = "App Bar Text",
                navigationIconType = NavigationIconType.Back(onIconClicked = {})
            )
            TopBar(
                apBarText = "App Bar Text",
                navigationIconType = NavigationIconType.Menu(onIconClicked = {})
            )
        }
    }
}