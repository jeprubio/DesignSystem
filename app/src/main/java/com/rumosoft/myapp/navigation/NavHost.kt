package com.rumosoft.myapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rumosoft.components.appbars.AppBars
import com.rumosoft.components.appbars.TopBar
import com.rumosoft.components.buttons.Buttons
import com.rumosoft.components.buttons.FilledButton
import com.rumosoft.components.colours.Colours
import com.rumosoft.components.typography.Typographies
import com.rumosoft.myapp.navigation.NavComponentItem.AppBars
import com.rumosoft.myapp.navigation.NavComponentItem.Buttons
import com.rumosoft.myapp.navigation.NavComponentItem.Colours
import com.rumosoft.myapp.navigation.NavComponentItem.ComponentsList
import com.rumosoft.myapp.navigation.NavComponentItem.Typographies

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
            Buttons(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppBars.route) {
            AppBars(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Colours.route) {
            Colours(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Typographies.route) {
            Typographies(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


@Composable
private fun ComponentsList(navigateTo: (destination: String) -> Unit) {
    Scaffold(
        topBar = { TopBar("Design System Catalog") },
    ) { contentPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(contentPadding),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Text(
                    text = "Components",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                FilledButton.Primary.Create(
                    text = "Buttons",
                    onClick = {
                        navigateTo(Buttons.route)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.8f)
                )
                FilledButton.Primary.Create(
                    text = "AppBar",
                    onClick = {
                        navigateTo(AppBars.route)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.8f)
                )
                FilledButton.Primary.Create(
                    text = "Colours",
                    onClick = {
                        navigateTo(Colours.route)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.8f)
                )
                FilledButton.Primary.Create(
                    text = "Typographies",
                    onClick = {
                        navigateTo(Typographies.route)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.8f)
                )
            }
        }
    }
}