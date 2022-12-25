package com.fakhir.mobile.todolistcompose.common.composable

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

@Composable
fun BasicToolbar(@StringRes title: Int) {
    TopAppBar(title = { Text(stringResource(title)) }, backgroundColor = toolbarColor())
}


@Composable
fun ActionToolbar(
    @StringRes title: Int,
    @DrawableRes endActionIcon: Int,
    modifier: Modifier,
    endAction: () -> Unit
) {
    TopAppBar(
        {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.h6,
            )
        },
        backgroundColor = toolbarColor(),
        actions = {
            Box(modifier) {
                IconButton(onClick = endAction) {
                    Icon(painter = painterResource(endActionIcon), contentDescription = "Action")
                }
            }
        }
    )
}

@Composable
private fun toolbarColor(): Color {
    return MaterialTheme.colors.background
}