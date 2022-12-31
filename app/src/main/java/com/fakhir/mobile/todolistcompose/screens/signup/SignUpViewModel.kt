package com.fakhir.mobile.todolistcompose.screens.signup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fakhir.mobile.todolistcompose.LOGIN_SCREEN
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.SETTINGS_SCREEN
import com.fakhir.mobile.todolistcompose.SIGN_UP_SCREEN
import com.fakhir.mobile.todolistcompose.common.ext.isValidEmail
import com.fakhir.mobile.todolistcompose.common.ext.isValidPassword
import com.fakhir.mobile.todolistcompose.common.ext.passwordMatches
import com.fakhir.mobile.todolistcompose.common.snackbar.SnackbarManager
import com.fakhir.mobile.todolistcompose.model.service.AccountService

class SignUpViewModel(private val accountService: AccountService) : ViewModel() {
    private var _uiState by mutableStateOf(SignUpUiState())

    fun getEmail(): String {
        return _uiState.email
    }

    fun getPassword(): String {
        return _uiState.password
    }

    fun getRepeatPassword(): String {
        return _uiState.repeatPassword
    }

    fun setEmail(email: String) {
        _uiState = _uiState.copy(email = email)
    }

    fun setPassword(password: String) {
        _uiState = _uiState.copy(password = password)
    }

    fun setRepeatPassword(repeatPassword: String) {
        _uiState = _uiState.copy(repeatPassword = repeatPassword)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        val email = _uiState.email
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(R.string.email_error)
            Log.d("TAG", "Signup: Email not valid")
            return
        }
        val password = _uiState.password
        if (!password.isValidPassword()) {
            SnackbarManager.showMessage(R.string.password_error)
            Log.d("TAG", "Signup: Password 1 not valid")
            return
        }
        val repeatPassword = _uiState.repeatPassword
        if (!password.passwordMatches(repeatPassword)) {
            SnackbarManager.showMessage(R.string.password_match_error)
            Log.d("TAG", "Signup: Passwords don't match")
            return
        }

        Log.d("TAG", "Signup: Success, proceeding to log in...")
        accountService.createUserAccount(email, password){
            openAndPopUp(SETTINGS_SCREEN, SIGN_UP_SCREEN)
        }
    }
}