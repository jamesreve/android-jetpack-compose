package com.develou.compose_componentes.examples.List

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ClickableListItems() {
    val items = List(5) { "Item ${it + 1}" }
    val context = LocalContext.current

    LazyColumn {
        items(items) { item ->
            ListItemRow(
                item = item,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Clic en '$item'", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}


@Composable
fun ScrollingEvents() {
    val items = List(20) { "Item $it" }
    val scrollState = rememberLazyListState()

    val scrollSummary = "firstVisibleItemIndex {${scrollState.firstVisibleItemIndex}}, " +
            "firstVisibleItemScrollOffset {${scrollState.firstVisibleItemScrollOffset}}"

    Column {
        CodeText(text = scrollSummary)
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        LazyColumn(state = scrollState) {
            items(items) { item ->
                ListItemRow(item)
            }
        }
    }
}

@Composable
fun ProgrammaticScrolling() {
    val items = List(30) { "Item ${it + 1}" }

    val scrollState = rememberLazyListState()
    var itemPosition by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Column {
        TextField(
            value = if (itemPosition == 0) "" else itemPosition.toString(),
            onValueChange = { value ->
                itemPosition = (value.toIntOrNull() ?: 0)
                coroutineScope.launch {
                    scrollState.animateScrollToItem((itemPosition - 1).coerceIn(0..items.size))
                }
            },
            label = { Text(text = "Posición del ítem") },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        LazyColumn(state = scrollState) {
            items(items) { item ->
                ListItemRow(item)
            }
        }
    }
}
