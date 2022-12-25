package com.fakhir.mobile.todolistcompose.common.ext

import com.fakhir.mobile.todolistcompose.model.Task

fun Task?.hasDueDate(): Boolean {
    return this?.dueDate.orEmpty().isNotBlank()
}

fun Task?.hasDueTime(): Boolean {
    return this?.dueTime.orEmpty().isNotBlank()
}
