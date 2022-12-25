package com.fakhir.mobile.todolistcompose

import android.view.WindowInsets.Type.statusBars
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fakhir.mobile.todolistcompose.screens.login.LoginScreen
import com.fakhir.mobile.todolistcompose.screens.splash.SplashScreen
import com.fakhir.mobile.todolistcompose.screens.tasks.TasksScreen
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
                        SplashScreen(navController = navController)
                    }
                    composable(LOGIN_SCREEN) {
                        LoginScreen()
                    }
                    composable(TASKS_SCREEN) {
                        TasksScreen()
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