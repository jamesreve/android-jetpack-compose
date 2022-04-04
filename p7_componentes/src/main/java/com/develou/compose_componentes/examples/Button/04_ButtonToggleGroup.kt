package com.develou.compose_componentes.examples.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.develou.compose_componentes.R

@Composable
fun ButtonToggleGroupExample() {
    val auto = "AUTO"
    val dark = "OSCURO"
    val light = "LIGHT"
    val options = listOf(auto, dark, light)

    var selectedOption by remember { mutableStateOf(options[0]) }

    ButtonToggleGroup(
        options = options,
        selectedOption = selectedOption,
        onOptionSelect = { selectedOption = it },
    )
}

@Composable
fun ButtonToggleGroup( // 1
    options: List<String>,
    selectedOption: String,
    onOptionSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) { // 2
        options.forEachIndexed { index, option -> // 3
            val selected = selectedOption == option // 4

            val border = if (selected) BorderStroke( // 5
                width = 1.dp,
                color = MaterialTheme.colors.primary
            ) else ButtonDefaults.outlinedBorder

            val shape = when (index) { // 6
                0 -> RoundedCornerShape(
                    topStart = 4.dp,
                    bottomStart = 4.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp
                )
                options.size - 1 -> RoundedCornerShape(
                    topStart = 0.dp, bottomStart = 0.dp,
                    topEnd = 4.dp,
                    bottomEnd = 4.dp
                )
                else -> CutCornerShape(0.dp)
            }

            val zIndex = if (selected) 1f else 0f

            val buttonModifier = when (index) { // 7
                0 -> Modifier.zIndex(zIndex)
                else -> {
                    val offset = -1 * index
                    Modifier
                        .offset(x = offset.dp)
                        .zIndex(zIndex)
                }
            }

            val colors = ButtonDefaults.outlinedButtonColors( // 8
                backgroundColor = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f)
                else MaterialTheme.colors.surface,
                contentColor = if (selected) MaterialTheme.colors.primary else Color.DarkGray
            )
            OutlinedButton( // 9
                onClick = { onOptionSelect(option) },
                border = border,
                shape = shape,
                colors = colors,
                modifier = buttonModifier.weight(1f)
            ) {
                Text(option) // 10
            }
        }
    }
}

@Composable
fun ButtonToggleGroupIconsExample() {
    val options = listOf(
        R.drawable.ic_format_align_center,
        R.drawable.ic_format_align_left,
        R.drawable.ic_format_align_right
    )
    var selectedOption by remember { mutableStateOf(options[0]) }
    var align by remember { mutableStateOf(TextAlign.Center) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(LoremIpsum(10).values.joinToString(), textAlign = align)

        Spacer(modifier = Modifier.size(16.dp))

        ButtonToggleGroup(
            options = options,
            selectedOption = selectedOption,
            onOptionSelect = { option ->
                selectedOption = option
                align = when (option) {
                    options[0] -> TextAlign.Center
                    options[1] -> TextAlign.Start
                    else -> TextAlign.End
                }
            }
        )
    }
}

@Composable
fun ButtonToggleGroup(
    options: List<Int>,
    selectedOption: Int,
    onOptionSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) {
        options.forEachIndexed { index, option ->
            val selected = selectedOption == option

            val border = if (selected) BorderStroke(
                1.dp,
                MaterialTheme.colors.primary
            ) else ButtonDefaults.outlinedBorder

            val shape = when (index) {
                0 -> RoundedCornerShape(
                    topStart = 4.dp,
                    bottomStart = 4.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp
                )
                options.size - 1 -> RoundedCornerShape(
                    topStart = 0.dp, bottomStart = 0.dp,
                    topEnd = 4.dp,
                    bottomEnd = 4.dp
                )
                else -> CutCornerShape(0.dp)
            }

            val zIndex = if (selected) 1f else 0f

            val buttonModifier = when (index) {
                0 -> Modifier.zIndex(zIndex)
                else -> {
                    val offset = -1 * index
                    Modifier
                        .offset(x = offset.dp)
                        .zIndex(zIndex)
                }
            }

            val colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f)
                else MaterialTheme.colors.surface,
                contentColor = if (selected) MaterialTheme.colors.primary else Color.DarkGray
            )

            OutlinedButton(
                onClick = { onOptionSelect(option) },
                border = border,
                shape = shape,
                colors = colors,
                contentPadding = PaddingValues(12.dp),
                modifier = buttonModifier.defaultMinSize(48.dp)
            ) {
                Icon(
                    painter = painterResource(option),
                    contentDescription = null
                )
            }
        }
    }
}