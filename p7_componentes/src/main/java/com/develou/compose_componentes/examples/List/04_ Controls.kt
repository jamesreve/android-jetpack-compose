package com.develou.compose_componentes.examples.List

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun ListItemRowWithControl(
    item: String,
    control: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = item,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.align(
                Alignment.CenterStart
            )
        )

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            control()
        }
    }
}

@Composable
fun SelectableList() {
    val items = List(5) { "Item ${it + 1}" }
    val selections = remember { mutableStateListOf<String>() }

    Column {
        Text(text = "Items seleccionados: ${selections.size}", modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(items) { item ->
                SelectableRow(
                    text = item,
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selections += item
                        } else {
                            selections -= item
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun SelectableRow(
    text: String,
    onCheckedChange: (Boolean) -> Unit
) {
    var checked by remember { mutableStateOf(false) }

    ListItemRowWithControl(
        item = text,
        control = {
            Checkbox(
                checked = checked,
                onCheckedChange = { value ->
                    checked = value
                    onCheckedChange(value)
                }
            )
        },
        modifier = Modifier
    )
}

@Composable
fun SwitchPreferenceItem() {
    var checked by remember { mutableStateOf(false) }

    ListItemRowWithControl(
        item = "Preferencia",
        control = {
            Switch(checked = checked, onCheckedChange = { checked = it })
        },
        modifier = Modifier
    )

    val modifier = if (checked) Modifier.wrapContentHeight() else Modifier.height(0.dp)

    Column(modifier = modifier.animateContentSize()) {
        ListItemRow("Dependencia 1")
        ListItemRow("Dependencia 2")
    }
}

data class ExpandableItem(val item: String, val details: List<String>)

@Composable
fun ExpandableList() {
    val items = List(5) { item ->
        ExpandableItem(
            item = "Item ${item + 1}",
            details = List(3) { "Detalle ${item + 1}.${it + 1}" }
        )
    }

    LazyColumn {
        items(items) { item ->
            ExpandableRow(item)
        }
    }
}

@Composable
private fun ExpandableRow(expandableItem: ExpandableItem) {
    var isExpanded by remember { mutableStateOf(false) }

    if (isExpanded)
        Divider()

    ListItemRowWithControl(
        item = expandableItem.item,
        control = {
            ExpandCollapseIcon(
                expanded = isExpanded,
                onIconClick = { isExpanded = !isExpanded },
                modifier = Modifier
            )
        }
    )

    val modifier = if (isExpanded) Modifier.wrapContentHeight() else Modifier.height(0.dp)

    Column(modifier = modifier.animateContentSize()) {
        expandableItem.details.forEach {
            ListItemRow(it)
        }
    }

    if (isExpanded)
        Divider()
}

@Composable
fun ExpandCollapseIcon(
    expanded: Boolean,
    onIconClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = onIconClick, modifier = modifier) {
        Icon(
            Icons.Filled.ArrowDropDown,
            "Icono de control para lista expandible",
            Modifier.rotate(
                if (expanded)
                    180f
                else
                    360f
            )
        )
    }
}