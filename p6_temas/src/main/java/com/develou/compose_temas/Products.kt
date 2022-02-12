package com.develou.compose_temas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.develou.compose_temas.theme.ProductsTheme

private val padding = Modifier.padding(horizontal = 16.dp)

@Composable
fun Products() {
    ProductCard(Modifier.padding(16.dp))
}

@Composable
fun ProductCard(modifier: Modifier) {

    Card(modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable { }) {
            Image(
                painter = painterResource(id = R.drawable.product),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
            )
            Spacer(Modifier.size(16.dp))
            Row(padding.fillMaxWidth()) {
                Text(
                    text = "Natural Skin Cream",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(0.8f)
                )
                Text(
                    "$24",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(0.2f)
                )
            }
            Spacer(Modifier.size(16.dp))
            Text(
                "Esta crema hidratante tiene una fórmula rica y " +
                        "cremosa que es absorbida fácilmente por tu piel " +
                        "para una hidratación profunda",
                modifier = padding,
                style = MaterialTheme.typography.body1
            )
            Spacer(Modifier.size(20.dp))
            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "AÑADIR AL CARRITO")
            }
            Spacer(Modifier.size(16.dp))
        }
    }
}

@Composable
@Preview("Sin Tema")
fun NoThemePreview() {
    Surface {
        ProductCard(Modifier.padding(16.dp))
    }
}

@Composable
@Preview("Tema Base Material Design")
fun BaselineThemePreview() {
    MaterialTheme {
        Surface {
            ProductCard(Modifier.padding(16.dp))
        }
    }
}

@Composable
@Preview("Tema Personalizado Claro")
fun CustomThemePreview() {
    ProductsTheme {
        Surface {
            ProductCard(Modifier.padding(16.dp))
        }
    }
}

@ExperimentalUnitApi
@Composable
@Preview("Tema Personalizado Oscuro")
fun DarkThemePreview() {
    ProductsTheme(true) {
        Surface {
            ProductCard(Modifier.padding(16.dp))
        }
    }
}

