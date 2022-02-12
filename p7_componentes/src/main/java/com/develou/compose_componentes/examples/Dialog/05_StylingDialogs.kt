package com.develou.compose_componentes.examples.Dialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun StyledAlertDialog(
    bodyText: String,
    buttonText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(bodyText)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
            ) {
                Text(text = buttonText)
            }
        },
        shape = RoundedCornerShape(
            topEndPercent = 50,
            bottomStartPercent = 50
        ),
        backgroundColor = Color(0xFF311b92),
        contentColor = Color.White
    )
}