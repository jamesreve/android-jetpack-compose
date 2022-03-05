package com.develou.compose_componentes.examples.ProgressIndicator

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun ProgressIndicatorScreen() {
    val tutorialSections = listOf(
        "1. LinearProgressIndicator determinado",
        "2. LinearProgressIndicator indeterminado",
        "3. LinearProgressIndicator coloreado",
        "4. CircularProgressIndicator determinado",
        "5. CircularProgressIndicator indeterminado",
        "6. CircularProgressIndicator coloreado"
    )

    Column {

        Text(
            modifier = Modifier.padding(all = 16.dp),
            text = "Indicadores De Progreso En Compose",
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

    var isExpanded by remember { mutableStateOf(true) }
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

        Box(
            modifier = contentModifier.padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            when (index) {
                0 -> DeterminedLinearProgress()
                1 -> UndeterminedLinearProgress()
                2 -> ColoredLinearProgress()
                3 -> UploadFileView()
                4 -> UndeterminedCircularProgress()
                5 -> ColoredCircularProgress()
            }
        }
    }
}

@Preview
@Composable
fun ProgressIndicatorPreview(){
    SurfaceForPreview {
        ProgressIndicatorScreen()
    }
}