package com.fakhir.mobile.todolistcompose.screens.settings

import com.fakhir.mobile.todolistcompose.LOGIN_SCREEN
import com.fakhir.mobile.todolistcompose.SIGN_UP_SCREEN
import com.fakhir.mobile.todolistcompose.SPLASH_SCREEN
import com.fakhir.mobile.todolistcompose.model.service.AccountService

class SettingsViewModel(private val accountService: AccountService)
{
    private val _uiState = SettingsUIState()

    val isAnonymousAccount: Boolean
        get() = _uiState.isAnonymousAccount

    fun onLogInClick(openScreen: (String) -> Unit) {
        openScreen(LOGIN_SCREEN)
    }

    fun onSignUpClick(openScreen: (String) -> Unit) {
        openScreen(SIGN_UP_SCREEN)
    }

    fun onSignOutClick(restartApp: (String) -> Unit) {
        accountService.signOut()
        restartApp(SPLASH_SCREEN)
    }

    fun onDeleteMyAccountClick(restartApp: (String) -> Unit) {
        restartApp("DELETE_MY_ACCOUNT_SCREEN")
    }
}