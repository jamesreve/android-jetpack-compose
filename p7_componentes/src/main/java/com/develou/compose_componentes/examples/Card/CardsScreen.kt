package com.develou.compose_componentes.examples.Card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R
import com.develou.compose_componentes.examples.Example
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun CardsScreen() {
    val examples = listOf(
        Example("Ej. 1") { CardTypes() },
        Example("Ej. 2") { StylingCard() },
        Example("Ej. 3") { CardList() },
        Example("Ej. 4") { ThemingCard() },
    )
    var state by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = state) {
            examples.forEachIndexed { index, example ->
                Tab(
                    text = { Text(example.title) },
                    selected = state == index,
                    onClick = { state = index }
                )

            }
        }

        examples[state].content()
    }
}

@Composable
fun StandardCard(
    modifier: Modifier = Modifier,
    elevation: Dp = 1.dp,
    border: BorderStroke? = null,
    background: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(background),
    shape: Shape = MaterialTheme.shapes.medium
) {
    Card(
        backgroundColor = background,
        contentColor = contentColor,
        shape = shape,
        elevation = elevation,
        border = border,
        modifier = modifier
    ) {
        // Contenedor
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Miniatura
                Box(
                    modifier = Modifier
                        .background(color = Color.LightGray, shape = CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_image),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(32.dp))

                Column(Modifier.fillMaxWidth()) {
                    // Encabezado
                    Text(text = "Título", style = MaterialTheme.typography.h6)

                    // Subtítulo
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(text = "Texto secundario", style = MaterialTheme.typography.body1)
                    }
                }
            }

            // Multimedia
            Image(
                painterResource(id = R.drawable.ic_image),
                contentDescription = "Multimedia de tarjeta",
                Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)
            )

            Row(Modifier.padding(start = 16.dp, end = 24.dp, top = 16.dp)) {

                // Texto de ayuda
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = LoremIpsum(50).values.take(10).joinToString(separator = " "),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {

                Box(
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                ) {

                    // Botones
                    Row(modifier = Modifier.align(Alignment.CenterStart)) {

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "ACCIÓN 1")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "ACCIÓN 2")
                        }
                    }

                    // Iconos
                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Favorite, contentDescription = null)
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Share, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
internal fun CardsScreenPreview() {
    SurfaceForPreview(
        modifier = Modifier.fillMaxSize()
    ) {
        CardsScreen()
    }
}