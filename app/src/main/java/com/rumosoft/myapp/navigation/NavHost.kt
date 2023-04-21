package com.rumosoft.myapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rumosoft.components.buttons.ButtonsScreen
import com.rumosoft.components.buttons.FilledButton
import com.rumosoft.myapp.navigation.NavComponentItem.Buttons
import com.rumosoft.myapp.navigation.NavComponentItem.ComponentsList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "componentsList") {
        composable(ComponentsList.route) {
            ComponentsList(
                navigateTo = { destination ->
                    navController.navigate(destination)
                }
            )
        }

        composable(Buttons.route) {
            LazyColumn {
                item {
                    ButtonsScreen()
                }
            }
        }
    }
}

@Composable
private fun ComponentsList(navigateTo: (destination: String) -> Unit) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            FilledButton.Primary.Create(
                text = "Buttons",
                onClick = {
                    navigateTo(Buttons.route)
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}