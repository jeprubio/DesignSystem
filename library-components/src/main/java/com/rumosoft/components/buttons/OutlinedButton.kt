package com.rumosoft.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class OutlinedButton {
    Primary, Secondary, Tertiary;

    private val buttonColour
        @Composable get() =
            when (this) {
                Primary -> MaterialTheme.colorScheme.primary
                Secondary -> MaterialTheme.colorScheme.secondary
                Tertiary -> MaterialTheme.colorScheme.tertiary
            }

    private val disabledColour
        @Composable get() = buttonColour.copy(alpha = 0.6f)

    @Composable
    fun Create(
        text: String,
        modifier: Modifier = Modifier,
        size: ButtonSize = ButtonSize.Medium,
        enabled: Boolean = true,
        onClick: () -> Unit = {}
    ) {
        OutlinedButton(
            onClick = onClick,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = buttonColour,
                disabledContentColor = disabledColour
            ),
            border = if (enabled) BorderStroke(
                1.dp,
                buttonColour
            ) else BorderStroke(
                1.dp,
                disabledColour
            ),
            shape = RoundedCornerShape(percent = 50),
            enabled = enabled,
            modifier = modifier
                .buttonSizeModifier(size)
        ) {
            DefaultButtonText(
                text = text,
                textColor = if (enabled) buttonColour else disabledColour,
                modifier = Modifier.padding(horizontal = size.horizontalPadding)
            )
        }
    }
}

@Composable
internal fun OutlinedButtons() {
    Column(modifier = Modifier.padding(16.dp)) {
        ButtonSize.values().onEach { buttonSize ->
            Text(
                text = buttonSize.name,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(8.dp)
            )
            OutlinedButtonsRow(buttonSize, enabled = true)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButtonsRow(buttonSize, enabled = false)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun OutlinedButtonsRow(buttonSize: ButtonSize, enabled: Boolean) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        listOf(
            OutlinedButton.Primary,
            OutlinedButton.Secondary,
            OutlinedButton.Tertiary,
        )
            .forEach {
                it.Create(
                    text = PREVIEW_BUTTON_TEXT,
                    size = buttonSize,
                    enabled = enabled,
                    modifier = Modifier.padding(bottom = 4.dp),
                )
            }
    }
}

@Preview(showBackground = true, widthDp = 660)
@Composable
internal fun PreviewOutlinedButtons() {
    MaterialTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedButtons()
            }
        }
    }
}
