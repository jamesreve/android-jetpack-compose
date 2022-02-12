package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import com.develou.compose_componentes.R
import kotlin.math.max

@Composable
fun PrefixExample() {
    var price by remember {
        mutableStateOf("")
    }

    TextField(
        value = price,
        onValueChange = { price = it },
        label = { Text("Precio") },
        visualTransformation = PrefixVisualTransformation("$ "),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

class PrefixVisualTransformation(private val prefix: String) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = AnnotatedString(prefix, SpanStyle(Color.Gray)) + text

        return TransformedText(transformedText, PrefixOffsetMapping(prefix))
    }
}

class PrefixOffsetMapping(private val prefix: String) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int = offset + prefix.length

    override fun transformedToOriginal(offset: Int): Int {
        return max(offset - prefix.length, 0)
    }
}

@Composable
fun SuffixExample() {
    var weight by remember {
        mutableStateOf("")
    }

    TextField(
        value = weight,
        onValueChange = { weight = it },
        label = { Text("Peso") },
        textStyle = TextStyle(textAlign = TextAlign.End),
        visualTransformation = SuffixVisualTransformation(" kg"),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

class SuffixVisualTransformation(private val suffix: String) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = text + AnnotatedString(suffix, SpanStyle(Color.Gray))

        return TransformedText(transformedText, SuffixOffsetMapping(text.text))
    }
}

class SuffixOffsetMapping(private val originalText: String) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int = offset

    override fun transformedToOriginal(offset: Int): Int {
        return if (offset > originalText.length) originalText.length else offset
    }
}

@Composable
fun PasswordExample() {
    var password by remember { mutableStateOf("") }
    var hidden by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { hidden = !hidden }) {
                val vector = painterResource(
                    if (hidden) R.drawable.ic_visibility
                    else R.drawable.ic_visibility_off
                )
                val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña"
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
}