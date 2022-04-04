package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonScreen() {

    val tutorialSections = listOf(
        "1. Crear Un RadioButton",
        "2. Añadir Etiqueta A Un RadioButton",
        "3. Crear Un Grupo De RadioButtons",
        "4. Usar El Modificador selectable()",
        "5. Deshabilitar Un RadioButton",
        "6. Cambiar El Color De Un RadioButton"
    )

    Column {

        Text(
            modifier = Modifier.padding(all = 16.dp),
            text = "RadioButtons En Compose",
            style = MaterialTheme.typography.h5.merge(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            itemsIndexed(tutorialSections) { index, item ->
                SectionRow(index, item)
            }
        }
    }

}

@Composable
fun SectionRow(
    index: Int,
    section: String
) {

    var isExpanded by remember { mutableStateOf(false) }
    val startExample = { isExpanded = !isExpanded }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Box(
            modifier = Modifier
                .height(48.dp)
                .clickable(onClick = startExample),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = section,
                style = MaterialTheme.typography.body1.merge(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        val contentModifier = if (isExpanded) Modifier else Modifier.height(0.dp)
        Box(modifier = contentModifier) {
            when (index) {
                0 -> Example1()
                1 -> Example2()
                2 -> Example3()
                3 -> Example4()
                4 -> Example5()
                5 -> Example6()
            }
        }
    }
}

@Composable
@Preview
private fun RadioButtonScreenPreview() {
    SurfaceForPreview(Modifier.padding(24.dp)) {
        RadioButtonScreen()
    }
}

@Composable
fun SurfaceForPreview(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    content: @Composable () -> Unit
) {
    MaterialTheme {
        Surface(modifier = modifier, color = color) {
            content()
        }
    }
}