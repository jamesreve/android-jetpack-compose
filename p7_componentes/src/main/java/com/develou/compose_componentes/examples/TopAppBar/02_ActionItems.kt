package com.develou.compose_componentes.examples.TopAppBar

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

data class ActionItem(
    val name: String,
    val icon: ImageVector? = null,
    val action: () -> Unit,
    val order: Int
)

@Composable
internal fun ListTopAppBar(
    openDrawer: () -> Unit,
    actionItems: List<ActionItem>
) {
    TopAppBar(
        title = { Text(text = "Action Items") },
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú")
            }
        },
        actions = {
            val (icons, options) = actionItems.partition { it.icon != null } // (1)

            icons.forEach { // (2)
                IconButton(onClick = it.action) {
                    Icon(imageVector = it.icon!!, contentDescription = it.name)
                }
            }

            val (isExpanded, setExpanded) = remember { mutableStateOf(false) } // (3)

            OverflowMenuAction(isExpanded, setExpanded, options) // (4)
        }
    )
}

@Composable
private fun OverflowMenuAction(
    expanded: Boolean,
    setExpanded: (Boolean) -> Unit,
    options: List<ActionItem>
) {
    IconButton(onClick = { setExpanded(true) }) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { setExpanded(false) },
            offset = DpOffset(x = 0.dp, y = 4.dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        option.action()
                        setExpanded(false)
                    }
                ) {
                    Text(text = option.name)
                }
            }
        }
    }
}