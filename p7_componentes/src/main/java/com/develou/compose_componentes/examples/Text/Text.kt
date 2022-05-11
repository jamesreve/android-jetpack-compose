package com.develou.compose_componentes.examples.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.develou.compose_componentes.R

@Composable
fun ShowText() {
    Text(text = "Texto En Compose")
}

@Composable
fun ShowTextFromResources() {
    Column {
        Text(stringResource(R.string.string_res))
        Text(stringResource(R.string.format_string_res, 2))
        for (item in stringArrayResource(R.array.string_array_res)) {
            Text(item)
        }
    }
}

@Composable
fun TextColor() {
    Text("Color Cyan", color = Color.Cyan)
}

@Composable
fun TextSize() {
    Column {
        Text("Texto con 20sp", fontSize = 20.sp)
        Text("Texto con 10em", fontSize = 10.em)
    }
}

@Composable
fun ItalicText() {
    Text("Texto en cursiva", fontStyle = FontStyle.Italic)
}

@Composable
fun FontWeightText() {
    Column {
        Text("Texto con grosor W500", fontWeight = FontWeight.W500)
        Text("Texto con grosor Extra Bold", fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun FontFamilyText() {
    val besleyFontFamily = FontFamily(
        Font(R.font.besley_regular, FontWeight.Normal),
        Font(R.font.besley_medium, FontWeight.Medium),
        Font(R.font.besley_semibold, FontWeight.SemiBold),
        Font(R.font.besley_bold, FontWeight.Bold),
        Font(R.font.besley_extrabold, FontWeight.ExtraBold),
        Font(R.font.besley_black, FontWeight.Black)
    )
    Column {
        Text(
            "Besley Normal",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.Normal
        )
        Text(
            "Besley Medium",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.Medium
        )
        Text(
            "Besley Semi-bold",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            "Besley Bold",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Besley Extra-bold",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            "Besley Black",
            fontFamily = besleyFontFamily,
            fontWeight = FontWeight.Black
        )
    }
}

@Composable
fun LetterSpacingText() {
    Column {
        Text("Texto", letterSpacing = 0.15.em)
        Text("Texto", letterSpacing = 0.4.em)
    }
}

@Composable
fun TextDecorationExample() {
    Column {
        Text("Texto", textDecoration = TextDecoration.Underline)
        Text("Texto", textDecoration = TextDecoration.LineThrough)
        Text(
            "Texto",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
    }
}

@Composable
fun TextAlignExample() {
    Column {
        val paragraph = stringResource(R.string.paragraph_res)
        val width = Modifier.width(300.dp)
        Text(text = paragraph, textAlign = TextAlign.Start, modifier = width)
        Space()
        Text(text = paragraph, textAlign = TextAlign.Center, modifier = width)
        Space()
        Text(text = paragraph, textAlign = TextAlign.End, modifier = width)
        Space()
        Text(text = paragraph, textAlign = TextAlign.Justify, modifier = width)
    }
}

@Composable
fun LineHeightExample() {
    Row {
        Text("LineHeight = 20sp\nPárrafo\nPárrafo", lineHeight = 20.sp)
        Space()
        Text("LineHeight = 30sp\nPárrafo\nPárrafo", lineHeight = 30.sp)
    }
}

@Composable
internal fun OverflowExample() {
    Box(modifier = Modifier.width(300.dp)) {
        Column(Modifier.width(200.dp)) {
            TitleExample("Clip")
            Text(
                "Este texto excede el tamaño de 200dp",
                maxLines = 1
            )
            Space()
            TitleExample("Ellipsis")
            Text(
                "Este texto excede el tamaño de 200dp",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Space()
            TitleExample("Visible")
            Text(
                "Este texto excede el tamaño de 200dp",
                overflow = TextOverflow.Visible,
                softWrap = false
            )
        }
    }
}

@Composable
fun SoftWrapExample() {
    Row(Modifier.width(200.dp)) {
        Text(
            "Texto largo sin saltos de línea",
            softWrap = false,
            modifier = Modifier.weight(1f)
        )
        Space()
        Text(
            "Otro texto",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun MaxLinesExample() {
    Column {
        TitleExample("maxLines = 3")
        Text("Párrafo\n".repeat(4), maxLines = 3)
    }
}

@Composable
fun OnTextLayoutExample() {
    var lines: String by remember {
        mutableStateOf("X")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.width(150.dp)) {
            TitleExample("onTextLayout")
            Text(
                "¿Cuántas líneas se generan para este texto a 150dp?",
                onTextLayout = {
                    lines = "R:/${it.lineCount}"
                })
            Text(lines)
        }
    }
}

@Composable
fun SpanStyleExample() {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(Color.Yellow, fontSize = 24.sp)) {
                append("De")
            }
            withStyle(SpanStyle(Color.Blue, fontSize = 16.sp)) {
                append("ve")
            }

            withStyle(SpanStyle(Color.Red, fontSize = 12.sp)) {
                append("lou")
            }
        }
    )
}

@Composable
fun ParagraphStyleExample() {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(fontSize = 20.sp)) {
                append("lineHeight (20sp)")
            }
            withStyle(ParagraphStyle(lineHeight = 24.sp)) {
                append("En este texto aplicamos 24sp para la altura de línea\n")
            }
            withStyle(SpanStyle(fontSize = 20.sp)) {
                append("textDirection (Rtl)")
            }
            withStyle(ParagraphStyle(textDirection = TextDirection.Rtl)) {
                append("En este texto aplicamos una dirección de texto de derecha a izquierda\n")
            }
            withStyle(SpanStyle(fontSize = 20.sp)) {
                append("textAlign (Center)")
            }
            withStyle(ParagraphStyle(textAlign = TextAlign.Center)) {

                append("Este texto está alineado al centro\n")
            }
            withStyle(SpanStyle(fontSize = 20.sp)) {
                append("textIndent (20sp)")
            }
            withStyle(ParagraphStyle(textIndent = TextIndent(20.sp, 8.sp))) {
                append("En este texto aplicamos 16sp de sangría para la primera línea ")
                append("y 8sp para las demás.")
            }
        },
        modifier = Modifier
            .width(200.dp)
            .padding(16.dp)
    )
}

@Composable
fun SelectionContainerExample() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SelectionContainer {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Este texto puede ser seleccionado")
                DisableSelection {

                    Text("Esto no")
                }
                Text("Desde aquí vuelve a ser seleccionable")
            }
        }
    }
}

@Composable
fun ClickableTextExample() {
    var clickPos by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = AnnotatedString("Posición cliqueada -> $clickPos"),
            style = MaterialTheme.typography.h6
        ) { offset ->
            clickPos = offset
        }
    }
}

@Composable
fun TextUrlExample() {
    val text = buildAnnotatedString {
        append("Visita mi sitio ")
        pushStringAnnotation("URL", "https://www.develou.com")
        withStyle(
            SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("develou.com")
        }
        pop()
    }
    val uriHandler = LocalUriHandler.current
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        ClickableText(text, style = MaterialTheme.typography.body2) { offset ->
            text.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                uriHandler.openUri(annotation.item)
            }
        }
    }
}

@Composable
private fun TitleExample(text: String) {
    Text(text = text, style = MaterialTheme.typography.h6)
}

@Composable
private fun Space() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
@Preview
fun ExamplesPreview() {
    Surface {
        SoftWrapExample()
    }
}
