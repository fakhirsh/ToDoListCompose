package com.fakhir.mobile.todolistcompose.model

class TaskList {
    fun getTasks(): List<Task> {
        return listOf(
            Task(
                id = "1",
                title = "Write report",
                priority = "High",
                dueDate = "2022-12-23",
                dueTime = "14:00",
                description = "Write a report on the current state of the company",
                url = "https://company.com/reports",
                flag = true,
                completed = false
            ),
            Task(
                id = "2",
                title = "Attend meeting",
                priority = "Medium",
                dueDate = "2022-12-23",
                dueTime = "16:00",
                description = "Attend the weekly team meeting",
                url = "https://company.com/meetings",
                flag = false,
                completed = false
            ),
            Task(
                id = "3",
                title = "Submit expense report",
                priority = "Low",
                dueDate = "2022-12-24",
                dueTime = "09:00",
                description = "Submit the expense report for the past month",
                url = "https://company.com/expenses",
                flag = false,
                completed = false
            ),
            Task(
                id = "4",
                title = "Write blog post",
                priority = "High",
                dueDate = "2022-12-25",
                dueTime = "17:00",
                description = "Write a blog post about the latest product release",
                url = "https://company.com/blog",
                flag = true,
                completed = false
            ),
            Task(
                id = "5",
                title = "Review code",
                priority = "Medium",
                dueDate = "2022-12-26",
                dueTime = "10:00",
                description = "Review the code for the new feature",
                url = "https://company.com/code",
                flag = false,
                completed = false
            ),

        )
    }
}