package com.develou.compose_temas.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.develou.compose_temas.R

val Overlock = FontFamily(
    Font(R.font.overlock_regular),
    Font(R.font.overlock_bold, FontWeight.Bold)
)
val Nunito = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_bold, FontWeight.Bold)
)

@OptIn(ExperimentalUnitApi::class)
val ProductsTypography = Typography(
    h6 = TextStyle(
        fontFamily = Overlock,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        letterSpacing = TextUnit(0.15f, TextUnitType.Sp)
    ),
    body1 = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp)
    ),
    button = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = TextUnit(1.25f, TextUnitType.Sp)
    )
)