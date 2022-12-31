package com.fakhir.mobile.todolistcompose.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.composable.*
import com.fakhir.mobile.todolistcompose.common.ext.basicButton
import com.fakhir.mobile.todolistcompose.common.ext.fieldModifier

@Composable
fun SignUpScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel
) {
    //val uiState by viewModel.uiState
    val fieldModifier = Modifier.fieldModifier()

    BasicToolbar(R.string.create_account)

    Column(
        modifier = modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(viewModel.getEmail(), fieldModifier){
            //viewModel::onEmailChange
            viewModel.setEmail(it)
        }
        PasswordField(viewModel.getPassword(), fieldModifier){
            viewModel.setPassword(it)
        }
        RepeatPasswordField(viewModel.getRepeatPassword(), fieldModifier){
            viewModel.setRepeatPassword(it)
        }

        BasicButton(R.string.create_account, Modifier.basicButton()) {
            viewModel.onSignUpClick(openAndPopUp)
        }
    }
}
