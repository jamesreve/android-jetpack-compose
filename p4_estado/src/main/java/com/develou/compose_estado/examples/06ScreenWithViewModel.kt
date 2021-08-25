package com.develou.compose_estado.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.develou.compose_estado.viewmodel.SumViewModel

@Composable
@Preview
fun SumScreenWithViewModel(sumViewModel: SumViewModel = viewModel()) {
    val firstNumber by sumViewModel.number1.observeAsState("")
    val secondNumber by sumViewModel.number2.observeAsState("")
    val sum by sumViewModel.sum.observeAsState(0.0)

    SumContentWithViewModel(
        firstNumber,
        secondNumber,
        firstNumberChange = sumViewModel::onFirstNumberChange,
        secondNumberChange = sumViewModel::onSecondNumberChange,
        sum,
        onCalculate = sumViewModel::onCalculate
    )
}

@Composable
private fun SumContentWithViewModel(
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
                sum == 10.0 -> Color.Magenta
                else -> Color.Black
            }
        )

        Spacer()

        Button(onClick = onCalculate) {
            Text(text = "CALCULAR")
        }
    }
}