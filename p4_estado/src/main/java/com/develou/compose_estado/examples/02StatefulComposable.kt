package com.develou.compose_estado.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.develou.compose_estado.toDoubleOrZero

@Composable
@Preview
fun SumScreenStateful() {
    var firstNumber by remember { mutableStateOf("") } // 1
    var secondNumber by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf(0.0) }
    var sumColor by remember { mutableStateOf(Color.Black) }

    val onCalculate = { // 2
        sum = firstNumber.toDoubleOrZero() + secondNumber.toDoubleOrZero()
        sumColor = when {
            sum < 10.0 -> Color.Cyan
            sum > 10.0 -> Color.Blue
            sum == 10.0 -> Color.Magenta
            else -> Color.Black
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = firstNumber, // 3
            onValueChange = { firstNumber = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer()

        TextField(
            value = secondNumber, // 3
            onValueChange = { secondNumber = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer()

        Text(
            text = "Suma = $sum", // 3
            fontSize = 30.sp,
            color = sumColor // 3
        )

        Spacer()

        Button(onClick = onCalculate) { // 4
            Text(text = "CALCULAR")
        }
    }
}