package com.rumosoft.components.buttons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class FilledButton {
    Primary, Secondary, Black, White;

    private val buttonColours
        @Composable get(): ButtonColors {
            val containerColor = when (this) {
                Primary -> MaterialTheme.colorScheme.primary
                Secondary -> MaterialTheme.colorScheme.secondary
                Black -> Color.Black
                White -> Color.White
            }
            return ButtonDefaults.buttonColors(
                containerColor = containerColor,
                disabledContainerColor = containerColor.copy(alpha = 0.7f)
            )
        }

    private val textColour
        @Composable get() = when (this) {
            Primary -> MaterialTheme.colorScheme.onPrimary
            Secondary -> MaterialTheme.colorScheme.onSecondary
            Black -> Color.White
            White -> Color.Black
        }

    @Composable
    fun Create(
        text: String,
        modifier: Modifier = Modifier,
        size: ButtonSize = ButtonSize.Medium,
        enabled: Boolean = true,
        onClick: () -> Unit = {}
    ) {
        Button(
            onClick = onClick,
            colors = buttonColours,
            shape = RoundedCornerShape(percent = 50),
            enabled = enabled,
            modifier = modifier
                .buttonSizeModifier(size)
        ) {
            DefaultButtonText(
                text = text,
                textColor = textColour,
                modifier = Modifier.padding(horizontal = size.horizontalPadding)
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true, widthDp = 900)
@Composable
fun FilledButtons() {
    MaterialTheme {
        Surface(color = Color.LightGray) {
            Column(modifier = Modifier.padding(16.dp)) {
                ButtonSize.values().onEach { buttonSize ->
                    Text(
                        text = buttonSize.name,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    FilledButtonsRow(buttonSize, enabled = true)
                    Spacer(modifier = Modifier.height(8.dp))
                    FilledButtonsRow(buttonSize, enabled = false)
                }
            }
        }
    }
}

@Composable
private fun FilledButtonsRow(buttonSize: ButtonSize, enabled: Boolean) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        listOf(
            FilledButton.Primary,
            FilledButton.Secondary,
            FilledButton.Black,
            FilledButton.White
        )
            .forEach {
                it.Create(text = PREVIEW_BUTTON_TEXT, size = buttonSize, enabled = enabled)
            }
    }
}
