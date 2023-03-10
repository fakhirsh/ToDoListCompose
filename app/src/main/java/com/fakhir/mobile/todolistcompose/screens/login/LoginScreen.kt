package com.fakhir.mobile.todolistcompose.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.composable.*
import com.fakhir.mobile.todolistcompose.common.ext.basicButton
import com.fakhir.mobile.todolistcompose.common.ext.fieldModifier
import com.fakhir.mobile.todolistcompose.common.ext.textButton

@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier:Modifier = Modifier,
    viewModel:LoginViewModel
) {
    val msg by remember{ mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val imageHeight = 790.dp

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight),
            painter = painterResource(R.drawable.tasks_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            BasicToolbar(title = R.string.login_details)

            Text(
                text = msg,
                modifier = Modifier.padding(16.dp)
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //EmailField(uiState.email, viewModel::onEmailChange, Modifier.fieldModifier())
                EmailField(viewModel.getEmail(), Modifier.fieldModifier()){
                    viewModel.setEmail(it)
                }
                //PasswordField(uiState.password, viewModel::onPasswordChange, Modifier.fieldModifier())
                PasswordField(viewModel.getPassword(), Modifier.fieldModifier()){
                    viewModel.setPassword(it)
                }

                BasicButton(R.string.sign_in, Modifier.basicButton()) {
                    Log.d("TAG", "LoginScreen: Login button clicked")
                    viewModel.onSignInClick(openAndPopUp)
                }
                BasicTextButton(R.string.forgot_password, Modifier.textButton()) {
                    //viewModel.onForgotPasswordClick()
                }
            }
        }
    }
}