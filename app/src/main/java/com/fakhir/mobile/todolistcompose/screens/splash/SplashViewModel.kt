package com.fakhir.mobile.todolistcompose.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fakhir.mobile.todolistcompose.SPLASH_SCREEN
import com.fakhir.mobile.todolistcompose.TASKS_SCREEN
import com.fakhir.mobile.todolistcompose.model.service.AccountService

class SplashViewModel : ViewModel() {

    private val accountService: AccountService = AccountService()

    fun AppStart(openAndPopUp: (String, String) -> Unit) {
        if (accountService.hasUser) {
            Log.d("TAG:", "SplashViewModel --> Anonymous user: Signing in")
            openAndPopUp(TASKS_SCREEN, SPLASH_SCREEN)
        }
        else {
            Log.d("TAG:", "SplashViewModel --> No user found: Creating Anonymous user")
            createAnonymousAccount(openAndPopUp)
        }
        Log.d("TAG:", "SplashViewModel --> ${accountService.currentUserId}")
    }

    fun createAnonymousAccount(openAndPopUp: (String, String) -> Unit) {
        accountService.createAnonymousAccount()
        openAndPopUp(TASKS_SCREEN, SPLASH_SCREEN)
    }
}