package com.fakhir.mobile.todolistcompose.model.service

import android.util.Log
import com.fakhir.mobile.todolistcompose.model.Task
import com.google.firebase.firestore.FirebaseFirestore

class StorageService(accountService: AccountService) {
    private val accountService: AccountService
    private val db = FirebaseFirestore.getInstance()

    init {
        this.accountService = accountService
    }

    fun getTasks(){
        //val userId = accountService.currentUserId
        val userId = "kasf5cvusqgA64vltFHtNeVYqCd2"
        val taskList = mutableListOf<Task>()

        // get list of all documents in a collection
        db.collection(userId).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val task = Task(
                        id = document.id,
                        title = document.data["title"] as String,
                        priority = document.data["priority"] as String,
                        dueDate = document.data["dueDate"] as String,
                        dueTime = document.data["dueTime"] as String,
                        description = document.data["description"] as String,
                        url = document.data["url"] as String,
                        flag = document.data["flag"] as Boolean,
                        completed = document.data["completed"] as Boolean
                    )
                    taskList.add(task)
                }
                Log.d("TAG", "$taskList")
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }


    }

}