package com.rumosoft.components.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rumosoft.components.R

sealed interface NavigationIconType {
    object None : NavigationIconType
    class Back(val onIconClicked: () -> Unit) : NavigationIconType
    class Menu(val onIconClicked: () -> Unit) : NavigationIconType
}

@Composable
fun NavigationIcon(navigationIconType: NavigationIconType) {
    when (navigationIconType) {
        is NavigationIconType.None -> Unit
        is NavigationIconType.Back -> NavigationIconBack(onIconClicked = navigationIconType.onIconClicked)
        is NavigationIconType.Menu -> NavigationIconMenu(onIconClicked = navigationIconType.onIconClicked)
    }
}

@Composable
fun NavigationIconBack(onIconClicked: () -> Unit = {}) {
    IconButton(onClick = onIconClicked) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back)
        )
    }
}

@Composable
fun NavigationIconMenu(onIconClicked: () -> Unit = {}) {
    IconButton(onClick = onIconClicked) {
        Icon(
            Icons.Filled.Menu,
            contentDescription = stringResource(id = R.string.menu)
        )
    }
}
