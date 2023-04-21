package com.rumosoft.components.appbars

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
) {
    if (textCentered) {
        CenterAlignedTopAppBar(
            title = { Text(text = apBarText) },
            modifier = modifier,
        )
    } else {
        TopAppBar(
            title = { Text(text = apBarText) },
            modifier = modifier,
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    MaterialTheme {
        TopBar(
            apBarText = "App Bar Text",
        )
    }
}