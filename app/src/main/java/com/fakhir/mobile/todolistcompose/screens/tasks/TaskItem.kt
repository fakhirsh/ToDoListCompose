package com.fakhir.mobile.todolistcompose.screens.tasks

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fakhir.mobile.todolistcompose.R
import com.fakhir.mobile.todolistcompose.common.ext.hasDueDate
import com.fakhir.mobile.todolistcompose.common.ext.hasDueTime
import com.fakhir.mobile.todolistcompose.model.Task
import com.fakhir.mobile.todolistcompose.model.TaskList
import com.fakhir.mobile.todolistcompose.ui.theme.BrightOrange

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    val taskList = TaskList().getTasks()

    TaskItem(task = taskList[0])
}

@Composable
fun TaskItem(
    task: Task,
    //options: List<String>,
    //onCheckChange: () -> Unit,
    //onActionClick: (String) -> Unit
) {
    val checkedState = remember { mutableStateOf(false) }
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 8.dp),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Checkbox(
                checked = checkedState.value, //task.completed,
//                onCheckedChange = { onCheckChange() },
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier
                                .padding(8.dp, 0.dp)
                                //.background(MaterialTheme.colors.onBackground),
                //color = BrightOrange
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.subtitle1,
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = getDueDateAndTime(task),
                        style = MaterialTheme.typography.subtitle2,
                        //fontSize = 12.sp
                    )
                }
            }

            if (task.flag) {
                Icon(
                    painter = painterResource(R.drawable.ic_flag),
                    tint = BrightOrange,
                    contentDescription = "Flag"
                )
            }

//            DropdownContextMenu(options, Modifier.contextMenu(), onActionClick)
        }
    }
}

private fun getDueDateAndTime(task: Task): String {
    val stringBuilder = StringBuilder("")

    if (task.hasDueDate()) {
        stringBuilder.append(task.dueDate)
        stringBuilder.append(" ")
    }

    if (task.hasDueTime()){
        stringBuilder.append("at ")
        stringBuilder.append(task.dueTime)
    }

    return stringBuilder.toString()
}
