package com.fakhir.mobile.todolistcompose.screens.tasks

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.composable.ActionToolbar
import com.fakhir.mobile.todolistcompose.common.ext.smallSpacer
import com.fakhir.mobile.todolistcompose.common.ext.toolbarActions
import com.fakhir.mobile.todolistcompose.ui.theme.BrightOrange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TasksScreen(
    openScreen: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TasksViewModel
) {
    Log.d("TAG", "TaskScreen: TasksScreen() called...")

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onAddClick()
                          },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = BrightOrange,
                modifier = Modifier.padding(8.dp),
                //shape = RectangleShape,

            ) {
                Icon(Icons.Filled.Add, "Add")
            }
        }
    ) { padding ->

        val name = viewModel.getUserName()
        viewModel.reloadTasks()
        val tasks = viewModel.getTasks()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                ActionToolbar(
                    title = R.string.tasks,
                    modifier = Modifier.toolbarActions(),
                    endActionIcon = R.drawable.ic_settings,
                    endAction = { viewModel.onSettingsClick(openScreen) }

                )

                Spacer(modifier = Modifier.smallSpacer())

                Text(
                    text = name,
                    style = MaterialTheme.typography.h4
                )

                Spacer(modifier = Modifier.smallSpacer())

                LazyColumn {
                    items(tasks.size) { index ->
                        TaskItem(task = tasks[index])
                    }
                }
            }
        }
    }

//    LaunchedEffect(viewModel) { viewModel.loadTaskOptions() }
}
