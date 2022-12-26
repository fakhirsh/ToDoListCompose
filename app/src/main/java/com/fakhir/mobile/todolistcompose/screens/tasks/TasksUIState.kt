package com.fakhir.mobile.todolistcompose.screens.tasks

import com.fakhir.mobile.todolistcompose.model.Task

data class TasksUiState(
    val tasks:MutableList<Task> = mutableListOf(),
    val userName: String = ""
)