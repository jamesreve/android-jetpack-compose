package com.develou.compose_componentes.examples.Dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R


@Composable
fun DialogScreen() {
    val (actionText, setActionText) = remember { mutableStateOf("Ninguna") }

    val tutorialSections = listOf(
        "1. Diálogo De Alerta",
        "2. Diálogo Simple",
        "3. Diálogo Confirmación Selección Única",
        "4. Diálogo Confirmación Selección Múltiple",
        "5. Cambiar Estilo De Diálogo"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {

            Text(
                modifier = Modifier.padding(all = 16.dp),
                text = "Diálogos En Compose",
                style = MaterialTheme.typography.h5,
            )

            Spacer(modifier = Modifier.height(8.dp))

            tutorialSections.forEachIndexed { index, section ->
                SectionRow(section, index, setActionText)
            }

            Divider(modifier = Modifier.padding(top = 16.dp))

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Acción de diálogo",
                style = MaterialTheme.typography.caption
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = actionText
            )
        }
    }
}

@Composable
fun SectionRow(
    section: String,
    index: Int,
    setActionText: (String) -> Unit
) {
    val (dialogOpen, showDialog) = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    showDialog(true)
                })
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = section
        )
    }

    if (!dialogOpen) return

    when (index) {
        0 -> Example1(showDialog, setActionText)
        1 -> Example2(showDialog, setActionText)
        2 -> Example3(showDialog, setActionText)
        3 -> Example4(showDialog, setActionText)
        4 -> Example5(showDialog, setActionText)
    }
}

@Composable
fun Example1(
    showDialog: (Boolean) -> Unit,
    setActionText: (String) -> Unit
) {
    TutorialAlertDialog(
        bodyText = "¿Eliminar ítem?",
        confirmButtonText = "ELIMINAR",
        onConfirm = {
            setActionText("Ejemplo 1 -> 'ACEPTAR'")
        },
        cancelButtonText = "CANCELAR",
        onCancel = {
            setActionText("Ejemplo 1 -> 'CANCELAR'")
        },
        onDismiss = { showDialog(false) }
    )
}

@Composable
fun Example2(
    showDialog: (Boolean) -> Unit,
    setActionText: (String) -> Unit
) {

    val accounts = listOf(
        Account("drjlaw@outlook.com", R.drawable.ac1),
        Account("sopwith@sbcglobal.net", R.drawable.ac2),
        Account("rmcfarla@att.net", R.drawable.ac3)
    )

    AccountsDialog(
        accounts = accounts,
        onAccountClick = { account ->
            setActionText("Ejemplo 2 -> '${account.email}'")
            showDialog(false)
        },
        onAddAccountClick = {
            setActionText("Ejemplo 2 -> 'Añadir cuenta'")
            showDialog(false)
        },
        onDismiss = { showDialog(false) }
    )
}

@Composable
fun Example3(
    showDialog: (Boolean) -> Unit,
    setActionText: (String) -> Unit
) {
    val formats = listOf(
        "MM/DD/AA",
        "DD/MM/AA",
        "AA/MM/DD",
        "Mes D, AA"
    )

    ConfirmationDialog(
        items = formats,
        titleText = "Formato De Fecha",
        confirmButtonText = "ACEPTAR",
        onConfirm = { format ->
            setActionText("Ejemplo 3 -> '$format'")
            showDialog(false)
        },
        cancelButtonText = "CANCELAR",
        onCancel = {
            setActionText("Ejemplo 3 -> 'CANCELAR'")
            showDialog(false)
        },
        onDismiss = {
            showDialog(false)
        }
    )
}

@Composable
fun Example4(
    showDialog: (Boolean) -> Unit,
    setActionText: (String) -> Unit
) {
    val tags = listOf(
        "Datos",
        "Interfaz Gráfica",
        "Conectividad",
        "Segundo Plano"
    )

    MultiChoiceConfirmationDialog(
        items = tags,
        titleText = "Etiquetar como:",
        confirmButtonText = "ACEPTAR",
        onConfirm = { selectedTags: List<String> ->
            setActionText(
                if (selectedTags.isNotEmpty())
                    "Ejemplo 4 -> ${selectedTags.joinToString()}"
                else
                    "Ejemplo 4 -> 'Sin etiquetas'"
            )
        },
        cancelButtonText = "CANCELAR",
        onCancel = {
            setActionText("Ejemplo 4 -> 'CANCELAR'")
        },
        onDismiss = {
            showDialog(false)
        }
    )
}

@Composable
fun Example5(
    showDialog: (Boolean) -> Unit,
    setActionText: (String) -> Unit
) {

    StyledAlertDialog(
        bodyText = "Quedan solo cinco unidades de este producto.",
        buttonText = "Aceptar",
        onConfirm = {
            setActionText("Ejemplo 5 -> 'ACEPTAR'")
        },
        onDismiss = {
            showDialog(false)
        },
    )
}


@Composable
@Preview
fun DialogScreenPreview() {
    MaterialTheme {
        Surface {
            DialogScreen()
        }
    }
}