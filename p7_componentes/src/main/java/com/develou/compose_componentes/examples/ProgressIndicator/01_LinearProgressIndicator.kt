package com.develou.compose_componentes.examples.ProgressIndicator

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay


@Composable
fun DeterminedLinearProgress() {
    var progress by remember { mutableStateOf(0.0f) }

    LaunchedEffect(true) {

        for (i in 0..100 step 10) {
            delay(300)

            if (i == 100) {
                cancel()
            }

            progress = i / 100f
        }
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Sincronizando datos")

        Spacer(Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun UndeterminedLinearProgress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Escaneando medidores")

        Spacer(Modifier.height(16.dp))

        LinearProgressIndicator()
    }
}

@Composable
fun ColoredLinearProgress() {
    /*val blue500 = Color(0xFF2196F3)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        LinearProgressIndicator(
            color = blue500,
            backgroundColor = Color.LightGray
        )
    }*/
}

@Composable
@Preview
private fun LinearPreview() {
    SurfaceForPreview(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        UndeterminedLinearProgress()
    }
}