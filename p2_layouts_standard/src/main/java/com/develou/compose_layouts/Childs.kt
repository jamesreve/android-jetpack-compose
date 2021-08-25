package com.develou.compose_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val aColor = Color(0xFFfff59d)
private val bColor = Color(0xFFffe082)
private val cColor = Color(0xFFffcc80)

fun aModifier(size: Int) = applyModifier(size, color = aColor)
fun bModifier(size: Int) = applyModifier(size, color = bColor)
fun cModifier(size: Int) = applyModifier(size, color = cColor)

private fun applyModifier(size: Int, color: Color): Modifier {
    require(size < 200)
    return Modifier
        .size(size.dp)
        .background(color)
}