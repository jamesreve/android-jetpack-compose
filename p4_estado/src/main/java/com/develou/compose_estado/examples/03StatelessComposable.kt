package com.develou.compose_estado.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.develou.compose_estado.toDoubleOrZero


@Composable
@Preview
fun SumScreen() {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf(0.0) }

    SumContent(
        firstNumber,
        secondNumber,
        firstNumberChange = { firstNumber = it },
        secondNumberChange = { secondNumber = it },
        sum,
        onCalculate = { sum = firstNumber.toDoubleOrZero() + secondNumber.toDoubleOrZero() }
    )
}

@Composable
private fun SumContent(
    firstNumber: String,
    secondNumber: String,
    firstNumberChange: (String) -> Unit,
    secondNumberChange: (String) -> Unit,
    sum: Double,
    onCalculate: () -> Unit
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OperandTextField(
            label = "Número 1",
            number = firstNumber,
            numberChange = firstNumberChange
        )

        Spacer()

        OperandTextField(
            label = "Número 2",
            number = secondNumber,
            numberChange = secondNumberChange
        )

        Spacer()

        Text(
            text = "Suma = $sum",
            fontSize = 30.sp,
            color = when {
                sum < 10.0 -> Color.Cyan
                sum > 10.0 -> Color.Blue
                sum == 10.0 -> Color.Red
                else -> Color.Black
            }
        )

        Spacer()

        Button(onClick = onCalculate) {
            Text(text = "CALCULAR")
        }
    }
}