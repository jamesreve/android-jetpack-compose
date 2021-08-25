package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue

@Composable
@Preview
fun OffsetExample() {
    Box(
        Modifier
            .size(100.dp)
            .offset(10.dp, 15.dp)
            .background(blue)
    )
}