package com.fakhir.mobile.todolistcompose.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.composable.BasicToolbar

@Composable
fun LoginScreen() {
    Column {
        BasicToolbar(title = R.string.login_details)
    }
}