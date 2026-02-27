package com.reringuy.pinterwork.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.reringuy.pinterwork.component.EmailTextField
import com.reringuy.pinterwork.component.GoogleButton
import org.jetbrains.compose.resources.painterResource
import pinterwork.composeapp.generated.resources.Res
import pinterwork.composeapp.generated.resources.visibility_64dp
import pinterwork.composeapp.generated.resources.visibility_off_64dp

@Composable
fun LoginCredentialsWrapper(email: String, onNavigateBack: () -> Unit, onLogin: () -> Unit) {
    LoginCredentials(email, onNavigateBack, onLogin)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCredentials(email: String, onNavigateBack: () -> Unit, onLoginPressed: () -> Unit) {
    var auxEmail by remember { mutableStateOf(email) }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    val passwordIcon = if (!showPassword)
        Res.drawable.visibility_64dp else Res.drawable.visibility_off_64dp

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Entrar",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.Rounded.Close, contentDescription = "Fechar")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(16.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GoogleButton { }
            Text(
                modifier = Modifier.padding(0.dp, 12.dp),
                text = "Ou",
                style = MaterialTheme.typography.titleMedium
            )
            EmailTextField(value = auxEmail, onDone = {}) { auxEmail = it }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                shape = MaterialTheme.shapes.medium,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    platformImeOptions = null,
                    showKeyboardOnFocus = null,
                    hintLocales = null
                ),
                visualTransformation = if (showPassword)
                    VisualTransformation.None else PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            painter = painterResource(passwordIcon),
                            contentDescription = "Mostrar/Esconder senha"
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = "Insira sua senha",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )

            Spacer(modifier = Modifier.padding(0.dp, 8.dp))

            Button(onClick = onLoginPressed, enabled = auxEmail.isNotEmpty() && password.isNotEmpty()) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Entrar",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }

            TextButton(onClick = {}) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Esqueceu a senha?",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}