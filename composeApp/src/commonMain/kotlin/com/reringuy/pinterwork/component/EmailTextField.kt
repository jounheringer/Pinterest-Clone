package com.reringuy.pinterwork.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailTextField(value: String, onDone: () -> Unit, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        shape = MaterialTheme.shapes.medium,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrectEnabled = false,
            keyboardType = KeyboardType.Unspecified,
            imeAction = ImeAction.Done,
            platformImeOptions = null,
            showKeyboardOnFocus = null,
            hintLocales = null
        ),
        keyboardActions = KeyboardActions(
            onDone = { onDone() }
        ),
        trailingIcon = {
            if (value.isNotEmpty())
                IconButton(onClick = { onValueChange("") }) {
                    Icon(imageVector = Icons.Rounded.Close, contentDescription = "Limpar")
                }
        },
        placeholder = {
            Text(
                text = "Endereço de email",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}