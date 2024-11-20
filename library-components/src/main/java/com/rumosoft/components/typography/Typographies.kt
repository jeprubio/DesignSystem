package com.rumosoft.components.typography

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumosoft.components.appbars.NavigationIconBack
import com.rumosoft.components.appbars.TopBar

@Composable
fun Typographies(
    onBack: () -> Unit = {},
) {
    val typographies = typographies()

    Scaffold(
        topBar = {
            TopBar(
                "Typographies",
                navigationIconType = NavigationIconBack(onBack)
            )
        },
    ) { contentPadding ->
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.padding(contentPadding),
        ) {
            items(typographies) {
                ElevatedCard(
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = it.name,
                            style = it.typography,
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun typographies(): List<Typo> {
    return listOf(
        Typo(
            name = "displayLarge",
            typography = MaterialTheme.typography.displayLarge
        ),
        Typo(
            name = "displayMedium",
            typography = MaterialTheme.typography.displayMedium
        ),
        Typo(
            name = "displaySmall",
            typography = MaterialTheme.typography.displaySmall
        ),
        Typo(
            name = "headlineLarge",
            typography = MaterialTheme.typography.headlineLarge
        ),
        Typo(
            name = "headlineMedium",
            typography = MaterialTheme.typography.headlineMedium
        ),
        Typo(
            name = "headlineSmall",
            typography = MaterialTheme.typography.headlineSmall
        ),
        Typo(
            name = "titleLarge",
            typography = MaterialTheme.typography.titleLarge
        ),
        Typo(
            name = "titleMedium",
            typography = MaterialTheme.typography.titleMedium
        ),
        Typo(
            name = "titleSmall",
            typography = MaterialTheme.typography.titleSmall
        ),
        Typo(
            name = "bodyLarge",
            typography = MaterialTheme.typography.bodyLarge
        ),
        Typo(
            name = "bodyMedium",
            typography = MaterialTheme.typography.bodyMedium
        ),
        Typo(
            name = "bodySmall",
            typography = MaterialTheme.typography.bodySmall
        ),
        Typo(
            name = "labelLarge",
            typography = MaterialTheme.typography.labelLarge
        ),
        Typo(
            name = "labelMedium",
            typography = MaterialTheme.typography.labelMedium
        ),
        Typo(
            name = "labelSmall",
            typography = MaterialTheme.typography.labelSmall
        ),
    )
}

data class Typo(val name: String, val typography: TextStyle)

@Preview(showBackground = true, heightDp = 1350)
@Composable
private fun PreviewTypographies() {
    MaterialTheme {
        Surface {
            Typographies()
        }
    }
}