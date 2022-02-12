package com.develou.compose_componentes.examples.Dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun TutorialAlertDialog(
    titleText: String? = null,
    bodyText: String,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {
    val title: @Composable (() -> Unit)? = if (titleText.isNullOrBlank())
        null
    else {
        { Text(text = titleText) }
    }

    AlertDialog(
        title = title,
        text = {
            Text(
                text = bodyText
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                }) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onCancel()
                onDismiss()
            }) {
                Text(text = cancelButtonText)
            }
        }
    )
}