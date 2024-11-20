package com.rumosoft.components.colours

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumosoft.components.appbars.NavigationIconBack
import com.rumosoft.components.appbars.TopBar

@Composable
fun Colours(
    onBack: () -> Unit = {},
) {
    val colours = colours()

    Scaffold(
        topBar = {
            TopBar(
                "Colours",
                navigationIconType = NavigationIconBack(onBack)
            )
        },
    ) { contentPadding ->
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.padding(contentPadding),
        ) {
            items(colours) {
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
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(horizontal = 16.dp)
                        )
                        Surface(
                            shadowElevation = 8.dp,
                            tonalElevation = 8.dp
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(color = it.colour)
                                    .size(100.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun colours(): List<Colour> {
    return listOf(
        Colour(
            name = "Primary",
            colour = MaterialTheme.colorScheme.primary
        ),
        Colour(
            name = "Inverse Primary",
            colour = MaterialTheme.colorScheme.inversePrimary
        ),
        Colour(
            name = "Secondary",
            colour = MaterialTheme.colorScheme.secondary
        ),
        Colour(
            name = "Tertiary",
            colour = MaterialTheme.colorScheme.tertiary
        ),
        Colour(
            name = "Error",
            colour = MaterialTheme.colorScheme.error
        ),
        Colour(
            name = "Surface",
            colour = MaterialTheme.colorScheme.surface
        ),
        Colour(
            name = "Background",
            colour = MaterialTheme.colorScheme.background
        ),
    )
}

data class Colour(val name: String, val colour: Color)

@Preview(showBackground = true, heightDp = 1050)
@Composable
private fun PreviewColours() {
    MaterialTheme {
        Surface {
            Colours()
        }
    }
}