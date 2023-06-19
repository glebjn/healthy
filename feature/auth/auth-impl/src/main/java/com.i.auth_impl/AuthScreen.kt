@file:OptIn(ExperimentalMaterial3Api::class)
package com.i.auth_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthScreen() {
    Column {
        Header()
        LoginInput()
        Footer()
    }
}

@Composable
fun Header() {
    val text = stringResource(id = R.string.auth_login_title)
    Text(text)
}

@Composable
fun LoginInput() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { text ->
            email = text
        },
        placeholder = {
            val hint = stringResource(id = R.string.auth_login_email_hint)
            Text(hint)
        }
    )
    TextField(
        value = password,
        onValueChange = { text ->
            password = text
        },
        placeholder = {
            val hint = stringResource(id = R.string.auth_login_password_hint)
            Text(hint)
        }
    )
}

@Composable
fun Footer() {
    Button(
        onClick = {  }
    ) {
        val text = stringResource(id = R.string.auth_login_apply)
        Text(text = text)
    }
    Text(text = stringResource(id = R.string.auth_login_restore_password))
}

@Preview
@Composable
fun AuthScreenPreview() {
    MaterialTheme {
        AuthScreen()
    }
}