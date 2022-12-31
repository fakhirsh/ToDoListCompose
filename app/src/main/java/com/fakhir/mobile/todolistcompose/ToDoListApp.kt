package com.fakhir.mobile.todolistcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fakhir.mobile.todolistcompose.model.service.AccountService
import com.fakhir.mobile.todolistcompose.model.service.StorageService
import com.fakhir.mobile.todolistcompose.screens.login.LoginScreen
import com.fakhir.mobile.todolistcompose.screens.login.LoginViewModel
import com.fakhir.mobile.todolistcompose.screens.settings.SettingsScreen
import com.fakhir.mobile.todolistcompose.screens.settings.SettingsViewModel
import com.fakhir.mobile.todolistcompose.screens.splash.SplashScreen
import com.fakhir.mobile.todolistcompose.screens.splash.SplashViewModel
import com.fakhir.mobile.todolistcompose.screens.tasks.TasksScreen
import com.fakhir.mobile.todolistcompose.screens.tasks.TasksViewModel
import com.fakhir.mobile.todolistcompose.ui.theme.ToDoListComposeTheme


@Composable
fun ToDoListApp() {
    ToDoListComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //val appState = rememberAppState()

            val navController = rememberNavController()
            val accountService = AccountService()
            val storageService = StorageService(accountService)

            val splashViewModel = SplashViewModel(accountService)
            val tasksViewModel = TasksViewModel(storageService)
            val settingsViewModel = SettingsViewModel(accountService)
            val loginViewModel = LoginViewModel()

            Scaffold(
//                snackbarHost = {
//                    SnackbarHost(
//                        hostState = it,
//                        modifier = Modifier.fillMaxSize(),
//                        snackbar = { data ->
//                            Snackbar(
//                                snackbarData = data,
//                                contentColor = MaterialTheme.colors.onPrimary,
//                            )
//                        }
//                    )
//                },
                //scaffoldState = appState.scaffoldState
            ) { innerPaddingModifier ->

                NavHost(
                    navController = navController,
                    startDestination = SPLASH_SCREEN,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {

                    composable(SPLASH_SCREEN) {
                        SplashScreen(openAndPopUp = { screen, popUpTo ->
                            navController.navigate(screen) {
                                popUpTo(popUpTo) { inclusive = true }
                            }
                        }, viewModel = splashViewModel)
                    }
                    composable(LOGIN_SCREEN){
                        LoginScreen(viewModel = loginViewModel)
                    }
                    composable(TASKS_SCREEN) {
                        TasksScreen(openScreen = { screen ->
                            navController.navigate(screen)
                        }, viewModel = tasksViewModel)
                    }
                    composable(SETTINGS_SCREEN){
                        SettingsScreen(
                            restartApp = {screen ->
                                navController.navigate(screen) {
                                    launchSingleTop = true
                                    popUpTo(0) { inclusive = true }
                                }
                            },
                            openScreen = { screen ->
                                navController.navigate(screen)
                            },
                            viewModel = settingsViewModel)
                    }
                }
            }
        }
    }
}

/*
@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    //resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, snackbarManager, resources, coroutineScope) {
        //MakeItSoAppState(scaffoldState, navController, snackbarManager, resources, coroutineScope)
    }
 */