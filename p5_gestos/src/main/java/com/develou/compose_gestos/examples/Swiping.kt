package com.develou.compose_gestos.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun SwipeableExample() {
    val width = 200.dp
    val baseAnchor = 50.dp
    val swipeableState = rememberSwipeableState(initialValue = "Fácil")

    val sizePx = with(LocalDensity.current) { baseAnchor.toPx() }

    val anchors =
        mapOf(
            0f to "Fácil",
            sizePx to "Normal",
            sizePx * 2 to "Difícil",
            sizePx * 3 to "Demente"
        )

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                swipeableState,
                anchors = anchors,
                orientation = Orientation.Horizontal,
                thresholds = { _, _ -> FractionalThreshold(0.5f) }
            )
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .offset { IntOffset(swipeableState.offset.value.toInt(), 0) }
                .size(baseAnchor)
                .background(Color.Cyan))
    }
}