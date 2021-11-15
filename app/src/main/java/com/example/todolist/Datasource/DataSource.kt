package com.example.todolist.Datasource

import com.example.todolist.tasksData

class DataSource {

    fun tasks(): List<tasksData> {
        return listOf<tasksData>(
            tasksData("task1", "TaskDscript1", 2, true),
            tasksData("task2", "TaskDscript2", 2, true),
            tasksData("task3", "TaskDscript3", 2, true),
            tasksData("task4", "TaskDscript4", 2, true),
            tasksData("task5", "TaskDscript5", 2, true),
            tasksData("task6", "TaskDscript6", 2, true),
            tasksData("task7", "TaskDscript7", 2, true),
            tasksData("task8", "TaskDscript8", 2, true),
            tasksData("task9", "TaskDscript9", 2, true),

            )
    }
}