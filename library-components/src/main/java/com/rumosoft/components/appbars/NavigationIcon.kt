package com.rumosoft.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rumosoft.components.R

interface NavigationIcon {
    @Composable operator fun invoke()
}

class NavigationIconBack(val onIconClicked: () -> Unit = {}): NavigationIcon {
    @Composable
    override fun invoke() {
        IconButton(onClick = onIconClicked) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.back)
            )
        }
    }
}

class NavigationIconMenu(val onIconClicked: () -> Unit = {}): NavigationIcon {
    @Composable
    override fun invoke() {
        IconButton(onClick = onIconClicked) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = stringResource(id = R.string.menu)
            )
        }
    }
}
