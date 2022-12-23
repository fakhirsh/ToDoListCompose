package com.fakhir.mobile.todolistcompose.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.fakhir.mobile.todolistcompose.TASKS_SCREEN
import kotlinx.coroutines.delay
import com.fakhir.mobile.todolistcompose.R

private const val SPLASH_TIMEOUT = 1000L

@Composable
fun SplashScreen(
    //openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    //viewModel: SplashViewModel = hiltViewModel()
    navController: NavController
) {
    Column(
        modifier =
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,

            )
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colors.onPrimary
            )
        }

    }

    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        navController.navigate(TASKS_SCREEN)
    }
}

