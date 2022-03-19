package com.develou.compose_componentes.examples.Menu

import androidx.compose.ui.graphics.vector.ImageVector

sealed interface MenuItem {

    data class Option(
        val name: String,
        val icon: ImageVector?,
        val enabled: Boolean = true
    ) : MenuItem

    object Divider : MenuItem
}