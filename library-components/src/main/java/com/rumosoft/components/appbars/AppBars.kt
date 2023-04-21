package com.rumosoft.components.appbars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, widthDp = 900, heightDp = 1250)
@Composable
fun AppBars() {
    MaterialTheme {
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column {
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
    }
}

