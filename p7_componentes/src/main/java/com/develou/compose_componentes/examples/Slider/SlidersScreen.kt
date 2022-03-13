package com.develou.compose_componentes.examples.Slider

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.develou.compose_componentes.examples.Example
import com.develou.compose_componentes.examples.ExampleScreen
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview
import kotlin.math.roundToInt

@Composable
fun SlidersScreen() {
    val examples = listOf(
        Example("1. Slider Continuo") { SimpleContinuousSlider() },
        Example("2. Slider Discreto") { SimpleDiscreteSlider() },
        Example("3. Slider Con Doble Selección") { SimpleRangeSlider() },
        Example("4. Slider Con Texto Lateral") { ContinuousSliderWithValue() },
        Example("5. Slider Con TextField") { DiscreteSliderWithTextField() },
        Example("6. Slider Coloreado") { ColoredSlider() }
    )
    ExampleScreen("Slider En Compose", examples)
}

@Composable
fun SimpleContinuousSlider() {
    val range = 0f..100f
    var selection by remember { mutableStateOf(50f) }

    Slider(
        value = selection,
        valueRange = range,
        onValueChange = { selection = it }
    )
}

@Composable
fun SimpleDiscreteSlider() {
    val range = 0.0f..100.0f
    val steps = 3
    var selection by remember { mutableStateOf(50f) }

    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = { selection = it }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleRangeSlider() {
    val range = 1.0f..1000.0f
    val steps = 4
    var price by remember { mutableStateOf(200.0f..400.0f) }

    RangeSlider(
        values = price,
        valueRange = range,
        steps = steps,
        onValueChange = { price = it }
    )
}

@Composable
fun ContinuousSliderWithValue() {
    val range = 25f..50f
    var fontSize by remember { mutableStateOf(30f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(100.dp)
        ) {

            Text(text = "Develou", fontSize = fontSize.sp)
        }

        Spacer(Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Slider(
                value = fontSize,
                valueRange = range,
                onValueChange = { fontSize = it },
                modifier = Modifier
                    .weight(0.9f)
                    .padding(end = 16.dp)
            )
            Text(
                text = fontSize.toInt().toString(),
                modifier = Modifier.weight(0.1f)
            )
        }
    }

}

@Composable
fun DiscreteSliderWithTextField() {
    val range = 0f..100f
    val steps = 4
    var sliderSelection by remember { mutableStateOf(range.start) }
    var selectionNumber by remember { mutableStateOf(range.start.toInt().toString()) }

    Row {

        Slider(
            value = sliderSelection,
            valueRange = range,
            steps = steps,
            onValueChange = { sliderSelection = it },
            onValueChangeFinished = {
                selectionNumber = sliderSelection.toInt().toString()
            },
            modifier = Modifier.width(250.dp)
        )

        Spacer(Modifier.width(16.dp))

        TextField(
            value = selectionNumber,
            onValueChange = {
                val segment = calculateSegment(it, range, steps)
                sliderSelection = segment
                selectionNumber = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.width(56.dp),
            colors = TextFieldDefaults.textFieldColors(unfocusedIndicatorColor = Color.Transparent)
        )
    }
}

fun calculateSegment(input: String, range: ClosedFloatingPointRange<Float>, steps: Int): Float {
    if (input.isBlank()) return 0.0F

    val selection = input.toFloat()

    if (selection > range.endInclusive) return range.endInclusive

    val segments = steps + 1
    val subRangeSize = (range.endInclusive - range.start) / segments

    val fraction: Float = range.endInclusive / selection
    val location = (segments / fraction).roundToInt()

    return location * subRangeSize
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColoredSlider() {
    val range = 1.0f..1000.0f
    val steps = 4
    var price by remember { mutableStateOf(1f..200f) }

    val green500 = Color(0xFF4CAF50)
    val green900 = Color(0xFF1B5E20)
    val lime500 = Color(0xFFCDDC39)

    RangeSlider(
        values = price,
        valueRange = range,
        steps = steps,
        onValueChange = { price = it },
        colors = SliderDefaults.colors(
            thumbColor = green900,
            activeTrackColor = green500,
            inactiveTrackColor = Color.LightGray.copy(alpha = 0.24f),
            activeTickColor = lime500,
            inactiveTickColor = lime500.copy(alpha = 0.56f)
        )
    )
}

@Preview
@Composable
fun SlidersPreview() {
    SurfaceForPreview(
        modifier = Modifier.fillMaxSize()
    ) {

        SlidersScreen()
    }
}