package com.fakhir.mobile.todolistcompose.model.service

import com.google.firebase.auth.FirebaseAuth

class AccountService() {
    private val auth: FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }

    val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    val hasUser: Boolean
        get() = auth.currentUser != null

    fun createAnonymousAccount() {
        auth.signInAnonymously()
    }

    fun signOut() {
        auth.signOut()
    }
}
