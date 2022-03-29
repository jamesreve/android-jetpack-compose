package com.develou.compose_componentes.examples.List

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.RadioGroup

@Composable
fun ListWithColumn(items: List<String>) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) {
        items.forEach { item ->
            ListItemRow(item)
        }
    }
}

@Composable
fun ListWithLazyColumn(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = item, style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ListComponentComparison() {
    val components = listOf("Column", "LazyColumn")
    val sizes = listOf(10, 1000)

    var component by remember { mutableStateOf(components.first()) }
    var size by remember { mutableStateOf(sizes.first()) }

    Column(modifier = Modifier.padding(top = 16.dp)) {

        Row {

            Column(modifier = Modifier.weight(0.5f)) {
                GroupTitle("Componente")
                RadioGroup(
                    items = components,
                    selection = component,
                    onItemClick = { component = it }
                )
            }

            Column(modifier = Modifier.weight(0.5f)) {
                GroupTitle("Tamaño")
                RadioGroup(
                    items = sizes.map(Int::toString),
                    selection = size.toString(),
                    onItemClick = { size = it.toInt() }
                )
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        val items = List(size) { "Item ${it + 1}" }
        when (component) {
            "Column" -> {
                Alert(Modifier.align(CenterHorizontally))
                ListWithColumn(items = items)
            }
            "LazyColumn" -> ListWithLazyColumn(items = items)
        }
    }
}

@Composable
private fun Alert(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(all = 16.dp)
            .then(modifier)
    ) {
        Icon(
            Icons.Default.Warning,
            null,
            tint = Color(0xFFFF5722),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Column + 1000 = Esperar por la recomposición",
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
private fun GroupTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 16.dp)
    )
}