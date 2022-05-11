package com.develou.compose_componentes.examples.TopAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R

private val ProminentTopAppBarHeight = 128.dp

// Ejemplo de Top App Bar prominente
@Composable
fun ProminentTopAppBar() {
    TopAppBar(
        modifier = Modifier.height(ProminentTopAppBarHeight)
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.high
        ) {
            Row(
                modifier = Modifier
                    .width(68.dp)
                    .align(Alignment.Top)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú")
                }
            }
        }

        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.high,
            LocalTextStyle provides MaterialTheme.typography.h5
        ) {
            Text(
                text = "Top App Bar Prominente",
                maxLines = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.Bottom)
                    .padding(bottom = 16.dp)
            )
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.Top)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.Top)
        ) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
        }
    }
}

@Composable
fun ProminentTopAppBarWithImage() {
    TopAppBar(
        modifier = Modifier.height(ProminentTopAppBarHeight),
        contentPadding = PaddingValues(all = 0.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp)
            ) {

                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high
                ) {

                    Row(
                        modifier = Modifier
                            .width(72.dp)
                            .align(Alignment.Top)
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú")
                        }
                    }
                }

                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high,
                    LocalTextStyle provides MaterialTheme.typography.h5
                ) {
                    Text(
                        text = "Top App Bar Prominente",
                        maxLines = 2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.Bottom)
                            .padding(bottom = 16.dp)
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
                }
            }
        }
    }
}