package com.fakhir.mobile.todolistcompose.model.service

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AccountService() {
    private val _auth: FirebaseAuth = FirebaseAuth.getInstance()

    val currentUserId: String
        get() = _auth.currentUser?.uid.orEmpty()

    val hasUser: Boolean
        get() = _auth.currentUser != null

    fun getUserName(): String {
        return _auth.currentUser?.displayName.orEmpty()
    }

    fun getUserEmail(): String {
        return _auth.currentUser?.email.orEmpty()
    }

    fun isAnonymous(): Boolean {
        return _auth.currentUser?.isAnonymous ?: false
    }

    fun createAnonymousAccount() {
        _auth.signInAnonymously()
    }

    fun signOut() {
        _auth.signOut()
    }

    fun createUserAccount(email: String, password: String, onSuccess: () -> Unit) {
        _auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "Authentication: User account created successfully")
                    onSuccess()
                } else {
                    Log.d("TAG", "Authentication: User account creation failed: ${task.exception?.message.orEmpty()}")
                }
            }
    }

    fun authenticate(email: String, password: String, onSuccess: ()->Unit) {
        _auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "Authentication Success.")
                    onSuccess()
                }
                else{
                    Log.d("TAG", "Authentication failed: ${task.exception?.message.orEmpty()}")
                }
            }
    }

    fun deleteAccount(onSuccess: () -> Unit) {
        _auth.currentUser?.delete()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("TAG", "User account deleted.")
                onSuccess()
            } else{
                Log.d("TAG", "User account deletion failed: ${task.exception?.message.orEmpty()}")
            }
        }
    }
}
