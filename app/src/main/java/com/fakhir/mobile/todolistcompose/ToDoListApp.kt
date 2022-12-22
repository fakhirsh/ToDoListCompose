package com.fakhir.mobile.todolistcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fakhir.mobile.todolistcompose.screens.splash.SplashScreen
import com.fakhir.mobile.todolistcompose.ui.theme.ToDoListComposeTheme

@Composable
fun ToDoListApp() {
    ToDoListComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SplashScreen()
        }
    }

}