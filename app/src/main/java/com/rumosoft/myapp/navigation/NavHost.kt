package com.rumosoft.myapp.navigation

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
import com.rumosoft.components.appbars.AppBars
import com.rumosoft.components.buttons.Buttons
import com.rumosoft.components.buttons.FilledButton
import com.rumosoft.myapp.navigation.NavComponentItem.AppBars
import com.rumosoft.myapp.navigation.NavComponentItem.Buttons
import com.rumosoft.myapp.navigation.NavComponentItem.ComponentsList

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
            Buttons()
        }

        composable(AppBars.route) {
            AppBars()
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
            FilledButton.Primary.Create(
                text = "AppBar",
                onClick = {
                    navigateTo(AppBars.route)
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}