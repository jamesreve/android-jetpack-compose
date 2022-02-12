package com.develou.compose_componentes.examples.Dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmationDialog(
    items: List<String>,
    titleText: String,
    confirmButtonText: String,
    onConfirm: (String) -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {
    val (selectedOption, selectOption) = remember { mutableStateOf(items.first()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = titleText,
                style = MaterialTheme.typography.h6
            )
        },
        buttons = {
            ConfirmationDialogContent(
                items = items,
                selectedOption = selectedOption,
                selectOption = selectOption,
                confirmButtonText = confirmButtonText,
                onConfirm = {
                    onConfirm(selectedOption)
                },
                cancelButtonText = cancelButtonText,
                onCancel = onCancel
            )
        }
    )
}

@Composable
fun ConfirmationDialogContent(
    items: List<String>,
    selectedOption: String,
    selectOption: (String) -> Unit,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit
) {

    Column(Modifier.selectableGroup()) {
        Spacer(modifier = Modifier.height(20.dp))

        Divider()

        items.forEach { item ->
            ItemRow(
                item = item,
                selected = item == selectedOption,
                select = selectOption
            )
        }

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = onCancel) {
                Text(text = cancelButtonText)
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick = onConfirm) {
                Text(text = confirmButtonText)
            }
        }
    }
}

@Composable
fun ItemRow(
    item: String,
    selected: Boolean,
    select: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .selectable(
                selected = selected,
                onClick = { select(item) },
                role = Role.RadioButton
            )
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = null)

        Spacer(modifier = Modifier.width(32.dp))

        Text(text = item)
    }
}