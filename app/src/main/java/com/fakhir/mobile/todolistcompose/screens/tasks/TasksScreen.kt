package com.fakhir.mobile.todolistcompose.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TasksScreen() {
    Scaffold() {
        Column() {
            Text(text = "Tasks")
        }
    }
}