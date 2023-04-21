package com.rumosoft.myapp.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val destination: String
    val navArgs: List<NamedNavArgument>
}


sealed class NavComponentItem(
    final override val destination: String,
    override val navArgs: List<NamedNavArgument> = emptyList(),
) : NavigationCommand {
    val route = run {
        val argKeys = navArgs.map { "{${it.name}}" }
        listOf(destination)
            .plus(argKeys)
            .joinToString("/")
    }

    object ComponentsList : NavComponentItem("componentsList")

    object Buttons : NavComponentItem(destination = "Buttons")
}
