package com.fakhir.mobile.todolistcompose.screens.splash

import androidx.annotation.Dimension
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fakhir.mobile.todolistcompose.TASKS_SCREEN
import kotlinx.coroutines.delay
import com.fakhir.mobile.todolistcompose.R
import kotlinx.coroutines.NonDisposableHandle.parent

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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val imageHeight = 790.dp
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight),
                painter = painterResource(R.drawable.splash),
                contentDescription = null,
                contentScale = ContentScale.Crop
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

