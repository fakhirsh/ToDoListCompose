package com.fakhir.mobile.todolistcompose.screens.tasks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fakhir.mobile.todolistcompose.SETTINGS_SCREEN
import com.fakhir.mobile.todolistcompose.model.Task
import com.fakhir.mobile.todolistcompose.model.TaskList
import com.fakhir.mobile.todolistcompose.model.service.StorageService

class TasksViewModel(private val storageService: StorageService) : ViewModel() {

    private var _uiState by mutableStateOf(TasksUiState())

    fun onAddClick(){
        val task = TaskList().getTasks().random()
        storageService.addTask(task){
            reloadTasks()
        }
    }

    fun onSettingsClick(openScreen: (String) -> Unit) {
        openScreen(SETTINGS_SCREEN)
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