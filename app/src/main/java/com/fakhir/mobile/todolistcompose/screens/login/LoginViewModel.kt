package com.fakhir.mobile.todolistcompose.screens.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.fakhir.mobile.todolistcompose.LOGIN_SCREEN
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.SETTINGS_SCREEN
import com.fakhir.mobile.todolistcompose.TASKS_SCREEN
import com.fakhir.mobile.todolistcompose.common.ext.isValidEmail
import com.fakhir.mobile.todolistcompose.common.snackbar.SnackbarManager
import com.fakhir.mobile.todolistcompose.model.service.AccountService

class LoginViewModel(private val accountService: AccountService) {
    private var _uiState by mutableStateOf(LoginUiState())

    fun setEmail(email: String) {
        _uiState = _uiState.copy(email = email)
    }

    fun setPassword(password: String) {
        _uiState = _uiState.copy(password = password)
    }

    fun getEmail(): String {
        return _uiState.email
    }

    fun getPassword(): String {
        return _uiState.password
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        val email = _uiState.email
        Log.d("TAG", "LoginScreen: Login button clicked")
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(R.string.email_error)
            Log.d("TAG", "LoginScreen: email not valid")
            return
        }
        val password = _uiState.password
        if (password.isBlank()) {
            SnackbarManager.showMessage(R.string.empty_password_error)
            Log.d("TAG", "LoginScreen: password not valid")
            return
        }

        Log.d("TAG", "LoginScreen: Success, proceeding to log in...")
        accountService.authenticate(email, password){
            openAndPopUp(SETTINGS_SCREEN, LOGIN_SCREEN)
        }

    }

}