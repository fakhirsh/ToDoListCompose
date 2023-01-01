package com.fakhir.mobile.todolistcompose.common.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.ui.theme.BrightOrange
import com.fakhir.mobile.todolistcompose.ui.theme.DarkOrange

@Composable
fun BasicField(
    @StringRes text: Int,
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        singleLine = true,
        modifier = modifier,
        value = value,
        onValueChange = { onNewValue(it) },
        placeholder = { Text(stringResource(text)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = BrightOrange,
            unfocusedBorderColor = DarkOrange)
    )
}

@Composable
fun EmailField(value: String, modifier: Modifier = Modifier, onNewValue: (String) -> Unit) {
    OutlinedTextField(
        singleLine = true,
        modifier = modifier,
        value = value,
        onValueChange = { onNewValue(it) },
        placeholder = {
            Text(
                text = stringResource(R.string.email),
                color = DarkOrange
            )
                      },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                tint = BrightOrange,
                contentDescription = "email"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = BrightOrange,
            unfocusedBorderColor = DarkOrange,
            focusedLabelColor = BrightOrange,
            unfocusedLabelColor = DarkOrange)
    )
}

@Composable
fun PasswordField(value: String, modifier: Modifier = Modifier, onNewValue: (String) -> Unit) {
    PasswordField(value, R.string.password, modifier, onNewValue)
}

@Composable
fun RepeatPasswordField(
    value: String,
    modifier: Modifier = Modifier,
    onNewValue: (String) -> Unit,
) {
    PasswordField(value, R.string.repeat_password, modifier, onNewValue)
}

@Composable
private fun PasswordField(
    value: String,
    @StringRes placeholder: Int,
    modifier: Modifier = Modifier,
    onNewValue: (String) -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }

    val icon =
        if (isVisible) painterResource(R.drawable.ic_visibility_on)
        else painterResource(R.drawable.ic_visibility_off)

    val visualTransformation =
        if (isVisible) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onNewValue(it) },
        placeholder = {
            Text(
                text = stringResource(placeholder),
                color = DarkOrange
            ) },
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock", tint = BrightOrange) },
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(painter = icon, contentDescription = "Visibility", tint = BrightOrange)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = BrightOrange,
            unfocusedBorderColor = DarkOrange)
    )
}
