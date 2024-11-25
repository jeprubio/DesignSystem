package com.rumosoft.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rumosoft.components.appbars.NavigationIconBack
import com.rumosoft.components.appbars.TopBar

const val PREVIEW_BUTTON_TEXT = "whatever"

enum class ButtonSize(val height: Dp, val horizontalPadding: Dp) {
    Xlarge(56.dp, 32.dp),
    Large(48.dp, 24.dp),
    Medium(40.dp, 16.dp),
    Small(32.dp, 8.dp)
}

@Composable
fun DefaultButtonText(
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.uppercase(),
        color = textColor,
        maxLines = 1,
        style = MaterialTheme.typography.labelLarge,
        modifier = modifier
    )
}

fun Modifier.buttonSizeModifier(size: ButtonSize) = then(
    Modifier
        .widthIn(min = 160.dp)
        .height(size.height)
)

@Composable
fun Buttons(
    onBack: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopBar(
                "Buttons",
                navigationIconType = NavigationIconBack(onBack)
            )
        },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "FilledButton",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(8.dp)
                )
                FilledButtons()
            }
            item {
                Text(
                    text = "OutlinedButton",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(8.dp)
                )
                OutlinedButtons()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 660, heightDp = 1300)
@Composable
private fun PreviewButtons() {
    MaterialTheme {
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize(),
        ) {
            Buttons()
        }
    }
}

