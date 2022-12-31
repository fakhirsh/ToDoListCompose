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

    fun getTasks(copyTaskList: (MutableList<Task>) -> Unit) {
        //val userId = accountService.currentUserId
        val userId = accountService.currentUserId
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

                copyTaskList(taskList)
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

    //function to create a new document on firebase database
    fun addTask(task: Task, refreshList: () -> Unit) {
        val userId = accountService.currentUserId
        db.collection(userId).add(task)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                refreshList()
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

    fun deleteAllForUser() {
        val userId = accountService.currentUserId
        db.collection(userId).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    db.collection(userId).document(document.id).delete()
                }
                Log.w("TAG", "User data deleted")
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

}