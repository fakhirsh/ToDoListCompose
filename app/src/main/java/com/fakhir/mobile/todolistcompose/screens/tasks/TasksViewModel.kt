package com.fakhir.mobile.todolistcompose.screens.tasks

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.fakhir.mobile.todolistcompose.model.Task
import com.fakhir.mobile.todolistcompose.model.service.StorageService
import kotlinx.coroutines.flow.MutableStateFlow

class TasksViewModel(private val storageService: StorageService) : ViewModel() {

    val tasks = mutableStateListOf<Task>()

    fun onAddClick(){
        Log.d("TAG:", "TasksViewModel --> Floating Add Btn Click")
    }

    fun getTasks(){
        storageService.getTasks()
    }

}