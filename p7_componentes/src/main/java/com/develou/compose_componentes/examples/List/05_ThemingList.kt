package com.develou.compose_componentes.examples.List

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomList() {
    val items = List(5) { "Item ${it + 1}" }

    val indigo500 = Color(0xFF3F51B5)
    val indigo900 = Color(0xFF1A237E)
    MaterialTheme(
        colors = MaterialTheme.colors.copy(surface = indigo500, onSurface = Color.White),
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) { item ->
                    ListItemRow(
                        item = item,
                        modifier = Modifier.background(
                            color = indigo900,
                            shape = RoundedCornerShape(50)
                        )
                    )
                }
            }
        }
    }
}