package com.develou.compose_componentes.examples.Dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun MultiChoiceConfirmationDialog(
    items: List<String>,
    titleText: String,
    confirmButtonText: String,
    onConfirm: (List<String>) -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {
    val (selectedOptions, selectOptions) = remember {
        mutableStateOf(emptyList<String>())
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = titleText,
                style = MaterialTheme.typography.h6
            )
        },
        buttons = {
            DialogContent(
                items = items,
                checkedOptions = selectedOptions,
                selectOptions = selectOptions,
                onConfirm = { onConfirm(selectedOptions) },
                onCancel = onCancel,
                onDismiss = onDismiss,
                confirmButtonText = confirmButtonText,
                cancelButtonText = cancelButtonText
            )
        }
    )
}

@Composable
private fun DialogContent(
    items: List<String>,
    checkedOptions: List<String>,
    selectOptions: (List<String>) -> Unit,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {

    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Divider()

        items.forEach { currentItem ->
            val isChecked = currentItem in checkedOptions
            ItemRow(
                item = currentItem,
                checked = isChecked,
                onValueChange = { checked ->
                    val checkedItems = checkedOptions.toMutableList()

                    if (checked)
                        checkedItems.add(currentItem)
                    else
                        checkedItems.remove(currentItem)

                    selectOptions(checkedItems)
                })
        }

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {
                onCancel()
                onDismiss()
            }) {
                Text(text = cancelButtonText)
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick = {
                onConfirm()
                onDismiss()
            }) {
                Text(text = confirmButtonText)
            }
        }
    }
}

@Composable
private fun ItemRow(
    item: String,
    checked: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .toggleable(
                value = checked,
                onValueChange = onValueChange,
                role = Role.Checkbox
            )
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = null)

        Spacer(modifier = Modifier.width(32.dp))

        Text(text = item)
    }
}