package com.develou.compose_componentes.examples.List

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ListWithContentPadding() {
    val items = List(10) { "Item ${it + 1}" }

    Column {
        val range = 0f..100f
        var selection by remember { mutableStateOf(0f) }

        Text(
            text = "contentPadding = PaddingValues(all = ${selection.toInt()}.dp)",
            fontFamily = FontFamily.Monospace,
            fontSize = TextUnit(12f, TextUnitType.Sp),
            modifier = Modifier
                .padding(16.dp)
                .align(CenterHorizontally)
        )
        Slider(
            value = selection,
            valueRange = range,
            onValueChange = {
                selection = it
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn(
            contentPadding = PaddingValues(all = selection.dp),
            modifier = Modifier.background(color = Color(0xFFE0F7FA))
        ) {
            items(items) { item ->
                ListItemRow(item, modifier = Modifier.background(Color.White))
            }
        }
    }
}

@Composable
fun ListWithContentSpacing() {
    val items = List(10) { "Item ${it + 1}" }

    Column {
        val range = 0f..100f
        var contentSpacing by remember { mutableStateOf(0f) }

        CodeText(
            text = "verticalArrangement = spacedBy(${contentSpacing.toInt()}.dp)",
            modifier = Modifier.align(CenterHorizontally)
        )
        Slider(
            value = contentSpacing,
            valueRange = range,
            onValueChange = {
                contentSpacing = it
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(contentSpacing.dp),
            modifier = Modifier.background(color = Color(0xFFE0F7FA))
        ) {
            items(items) { item ->
                ListItemRow(item, modifier = Modifier.background(Color.White))
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CodeText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontFamily = FontFamily.Monospace,
        fontSize = TextUnit(12f, TextUnitType.Sp),
        modifier = Modifier.padding(16.dp) then modifier
    )
}

@Composable
fun ListWithDividers() {
    val items = List(10) { "Item ${it + 1}" }

    Column {
        LazyColumn {
            items(items) { item ->
                ListItemRow(item)
                Divider()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListWithStickyHeaders() {
    val items = List(30) { "Item ${it + 1}" }
    val groups = items.chunked(5)
    LazyColumn {
        groups.forEachIndexed { index, group ->
            stickyHeader {
                Header("Grupo ${index + 1}")
            }

            items(group) { item ->
                ListItemRow(item)
            }
        }
    }
}

@Composable
private fun Header(title: String) {
    Surface(
        color = Color(0xFFE1F5FE),
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(text = title, Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
    }
}

@Composable
fun VerticalListWithHorizontalList() {
    val items = List(15) { "Item ${it + 2}" }
    val itemsForFirstRow = List(10) { "Item ${it + 1}" }

    LazyColumn {
        item {
            FirstItem(itemsForFirstRow)
        }

        items(items) { item ->
            ListItemRow(item)
        }
    }
}

@Composable
private fun FirstItem(recommended: List<String>) {
    Column {
        Text(text = "Item 1", modifier = Modifier.padding(start = 16.dp, bottom = 8.dp))
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = recommended,
                key = { itemAsId -> itemAsId }
            ) { item ->
                HorizontalItem(item)
            }
        }
    }
}

@Composable
private fun HorizontalItem(text: String) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                shape = RoundedCornerShape(topStartPercent = 20)
            )
            .width(120.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            contentAlignment = Center
        ) {

            Text(
                text = text,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
