package com.develou.compose_inicio

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginView(::login)
        }
    }

    private fun login() {
        Toast.makeText(
            this,
            "Iniciar sesión",
            Toast.LENGTH_SHORT
        ).show()
    }
}

@Composable
@Preview
fun LoginView(onClick: () -> Unit = {}) {
    val spaceKeyline = 16.dp

    Column(
        Modifier
            .fillMaxSize()
            .padding(spaceKeyline)
    ) {
        Text("Login", fontSize = 30.sp)

        Spacer(modifier = Modifier.size(spaceKeyline))

        TextField(
            value = "",
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {},
            label = { Text("Usuario") })

        Spacer(modifier = Modifier.size(spaceKeyline))

        TextField(
            value = "",
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {},
            label = { Text("Constraseña") })

        Spacer(modifier = Modifier.size(spaceKeyline))

        Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = onClick) {
            Text("Iniciar Sesión")
        }
    }
}