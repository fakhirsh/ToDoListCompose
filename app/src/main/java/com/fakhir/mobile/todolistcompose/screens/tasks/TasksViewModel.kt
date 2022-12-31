package com.fakhir.mobile.todolistcompose.screens.tasks

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fakhir.mobile.todolistcompose.model.Task
import com.fakhir.mobile.todolistcompose.model.service.StorageService

class TasksViewModel(private val storageService: StorageService) : ViewModel() {

    private var _uiState by mutableStateOf(TasksUiState())

    fun onAddClick(){
        Log.d("TAG:", "TasksViewModel --> Floating Add Btn Click")
//        val tasks = _uiState.tasks
//        tasks.add(Task("id: " + (1..10).random(), "title: " + (1..10).random(), "priority: " + (1..10).random(), "dueDate: " + (1..10).random(), "dueTime: " + (1..10).random(), "description: " + (1..10).random(), "url: " + (1..10).random(), false, false))
//        _uiState = _uiState.copy(
//            userName = "id: " + (1..10).random(),
//            tasks = tasks
//        )
        reloadTasks()
    }

    fun reloadTasks(){
        storageService.getTasks { taskList: MutableList<Task> ->
            _uiState = _uiState.copy(
                tasks = taskList
            )
        }
    }

    fun getTasks(): MutableList<Task> {
        return _uiState.tasks
    }

    fun getUserName(): String {
        return _uiState.userName
    }
}