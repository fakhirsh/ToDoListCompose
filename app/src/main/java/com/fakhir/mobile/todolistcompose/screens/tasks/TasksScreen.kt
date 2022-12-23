package com.fakhir.mobile.todolistcompose.screens.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.composable.ActionToolbar
import com.fakhir.mobile.todolistcompose.common.ext.toolbarActions
import com.fakhir.mobile.todolistcompose.model.TaskList

@Preview(showBackground = true)
@Composable
fun TasksScreen(
    //openScreen: (String) -> Unit,
    //modifier: Modifier = Modifier,
    //viewModel: TasksViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                //onClick = { viewModel.onAddClick(openScreen) },
                onClick = {  },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                //modifier = modifier.padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, "Add")
            }
        }
    ) {
        //val tasks = viewModel.tasks.collectAsStateWithLifecycle(emptyList())
        val tasks = TaskList().getTasks()
        //val options by viewModel.options

        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            ActionToolbar(
                title = R.string.tasks,
                modifier = Modifier.toolbarActions(),
                endActionIcon = R.drawable.ic_settings,
                //endAction = { viewModel.onSettingsClick(openScreen) }
                endAction = { }
            )

//            Spacer(modifier = Modifier.smallSpacer())

            LazyColumn {
                items(tasks.size) { index ->
                    TaskItem(task = tasks[index])
                }
            }
        }
    }

//    LaunchedEffect(viewModel) { viewModel.loadTaskOptions() }
}