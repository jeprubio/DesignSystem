package com.rumosoft.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

interface NavigationIcon {
    @Composable
    fun GetIcon()
}

class NavigationIconBack(private val onIconClicked: () -> Unit = {}): NavigationIcon {
    @Composable
    override fun GetIcon() {
        IconButton(onClick = onIconClicked) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
    }
}

class NavigationIconMenu(private val onIconClicked: () -> Unit = {}): NavigationIcon {
    @Composable
    override fun GetIcon() {
        IconButton(onClick = onIconClicked) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }
    }
}
