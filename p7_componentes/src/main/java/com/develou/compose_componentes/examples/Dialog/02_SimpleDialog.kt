package com.develou.compose_componentes.examples.Dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R

@Composable
fun AccountsDialog(
    accounts: List<Account>,
    onDismiss: () -> Unit,
    onAccountClick: (Account) -> Unit,
    onAddAccountClick: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Seleccionar cuenta",
                style = MaterialTheme.typography.h6
            )
        },
        buttons = {
            AccountsDialogContent(accounts, onAccountClick, onAddAccountClick)
        }
    )
}

@Composable
private fun AccountsDialogContent(
    accounts: List<Account>,
    onAccountClick: (Account) -> Unit,
    onAddAccountClick: () -> Unit
) {

    Column {
        Spacer(Modifier.height(20.dp))

        accounts.forEach { account ->
            AccountRow(account, onAccountClick)
        }

        AddAccountRow(onAddAccountClick)

        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun AccountRow(account: Account, onAccountClick: (Account) -> Unit) {
    Row(
        Modifier
            .clickable(onClick = { onAccountClick(account) })
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp),
            painter = painterResource(id = account.avatar),
            contentDescription = "Cuenta de ${account.email}"
        )

        Spacer(Modifier.width(20.dp))

        Text(text = account.email)
    }
}

@Composable
fun AddAccountRow(onAddAccountClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onAddAccountClick)
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(24.dp),
                imageVector = Icons.Filled.Add,
                contentDescription = "Opción para añadir cuenta"
            )
        }

        Spacer(Modifier.width(20.dp))

        Text(text = "Añadir cuenta")
    }
}

data class Account(
    val email: String,
    @DrawableRes val avatar: Int = R.drawable.no_avatar
)