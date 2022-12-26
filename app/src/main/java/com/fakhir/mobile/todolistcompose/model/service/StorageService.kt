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

    fun getTasks() {
        //val userId = accountService.currentUserId
        val userId = "kasf5cvusqgA64vltFHtNeVYqCd2"
        // get list of all documents in a collection
        db.collection(userId).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }


    }

}