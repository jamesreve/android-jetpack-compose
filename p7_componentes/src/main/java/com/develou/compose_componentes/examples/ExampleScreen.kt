package com.develou.compose_componentes.examples

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExampleScreen(tutorialTitle: String, examples: List<Example>) {
    Column {

        Text(
            modifier = Modifier.padding(all = 16.dp),
            text = tutorialTitle,
            style = MaterialTheme.typography.h5.merge(),
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            examples.forEach { example ->
                item {
                    SectionRow(example)
                }
            }
        }
    }
}

@Composable
fun SectionRow(
    example: Example
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
                text = example.title,
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
            example.content()
        }
    }
}


data class Example(val title: String, val content: (@Composable () -> Unit))