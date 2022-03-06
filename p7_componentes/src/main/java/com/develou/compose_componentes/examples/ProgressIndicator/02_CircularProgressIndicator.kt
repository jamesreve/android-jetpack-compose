package com.develou.compose_componentes.examples.ProgressIndicator

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay

@Composable
fun DeterminedCircularProgress(progress: Float) {
    val percentage: Int = (progress * 100).toInt()

    Box(contentAlignment = Alignment.Center) {
        Text(text = "$percentage%", style = MaterialTheme.typography.body2)
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(70.dp)
        )
    }
}

@Composable
fun UploadFileView() {
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
        Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
            .wrapContentHeight()
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp))
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        DeterminedCircularProgress(progress = animatedProgress)

        Spacer(Modifier.height(16.dp))

        Text(text = "Subiendo archivo...")

        Spacer(Modifier.height(8.dp))

        OutlinedButton(onClick = { }) {
            Text(text = "Cancelar")
        }
    }
}

@Composable
fun UndeterminedCircularProgress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        CircularProgressIndicator()

        Spacer(Modifier.height(16.dp))

        Text(text = "Cargando")
    }
}

@Composable
fun ColoredCircularProgress() {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Blue,
        targetValue = Color.Yellow,
        animationSpec = infiniteRepeatable(
            animation = tween(200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        CircularProgressIndicator(color = color)

        Spacer(Modifier.height(16.dp))

        Text(text = "Cargando")
    }
}

@Composable
@Preview
fun CircularPreview() {
    SurfaceForPreview(
        Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        UndeterminedCircularProgress()
    }
}