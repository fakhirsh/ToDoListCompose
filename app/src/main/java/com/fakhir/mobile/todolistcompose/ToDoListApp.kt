package com.fakhir.mobile.todolistcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fakhir.mobile.todolistcompose.screens.login.LoginScreen
import com.fakhir.mobile.todolistcompose.screens.splash.SplashScreen
import com.fakhir.mobile.todolistcompose.ui.theme.ToDoListComposeTheme


@Composable
fun ToDoListApp() {
    ToDoListComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //val appState = rememberAppState()

            Scaffold (
                snackbarHost = {
                    SnackbarHost(
                        hostState = it,
                        modifier = Modifier.fillMaxSize(),
                        snackbar = { data ->
                            Snackbar(
                                snackbarData = data,
                                contentColor = MaterialTheme.colors.onPrimary,
                            )
                        }
                    )
                },
                //scaffoldState = appState.scaffoldState
            ){
                //SplashScreen()
                LoginScreen()
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