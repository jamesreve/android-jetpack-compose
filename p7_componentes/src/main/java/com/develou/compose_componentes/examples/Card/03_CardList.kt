package com.develou.compose_componentes.examples.Card

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.Card.ExpandableCardItem.ItemDetail

data class CardItem(
    val title: String,
    val text: String
)

data class ExpandableCardItem(
    val title: String,
    val secondaryText: String,
    val details: ItemDetail
) {
    data class ItemDetail(val moreText: String)
}

@Composable
fun CardList() {
    val exampleOptions = listOf("Clickear Card", "Expandir Card")
    var exampleSelected by remember { mutableStateOf(exampleOptions.first()) }

    Column {

        ConfigSection(
            title = "Gestos",
            options = exampleOptions,
            selection = exampleSelected,
            onOptionSelected = { exampleSelected = it },
            modifier = Modifier.padding(16.dp)
        )

        Divider()

        if (exampleSelected == "Clickear Card") {
            ListWithClickableCards()
        } else {
            ListWithExpandableCards()
        }
    }

}

@Composable
fun ListWithClickableCards() {
    val items = List(10) { index ->
        val position = index + 1
        CardItem(
            title = "Título $position",
            text = "Texto secundario $position"
        )
    }
    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            CardRow(
                cardItem = item,
                onClick = { context.toast("Clic en $item") }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardRow(cardItem: CardItem, onClick: () -> Unit) {
    Card(onClick = onClick) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = cardItem.title, style = MaterialTheme.typography.h6)
            Text(text = cardItem.text, style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
fun ListWithExpandableCards() {
    val items = List(10) { index ->
        val position = index + 1
        ExpandableCardItem(
            title = "Título $position",
            secondaryText = "Texto secundario $position",
            ItemDetail("Elementos adicionales $position")
        )
    }

    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            ExpandableCardRow(expandableCardItem = item)
        }
    }
}

@Composable
fun ExpandableCardRow(
    expandableCardItem: ExpandableCardItem
) {
    var expanded by remember { mutableStateOf(false) }

    Card {
        Column(modifier = Modifier.animateContentSize()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = expandableCardItem.title, style = MaterialTheme.typography.h6)
                    Text(
                        text = expandableCardItem.secondaryText,
                        style = MaterialTheme.typography.body1
                    )
                }

                ExpandableCardIcon(
                    expanded = expanded,
                    onIconClick = { expanded = !expanded },
                    modifier = Modifier.align(
                        Alignment.CenterEnd
                    )
                )
            }

            if (expanded)
                Divider(thickness = Dp.Hairline, modifier = Modifier.padding(horizontal = 16.dp))

            Text(
                text = expandableCardItem.details.moreText,
                modifier = Modifier
                    .height(if (expanded) 56.dp else 0.dp)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ExpandableCardIcon(
    expanded: Boolean,
    onIconClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = onIconClick, modifier = modifier) {
        Icon(
            Icons.Filled.KeyboardArrowDown,
            "Icono para expandir tarjeta",
            Modifier.rotate(
                if (expanded)
                    180f
                else
                    360f
            )
        )
    }
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}