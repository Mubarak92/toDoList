package com.example.todolist.Datasource

import com.example.todolist.tasksData

class DataSource {
    fun tasks():List<tasksData>{
        return listOf<tasksData>(
            tasksData("task1","TaskDscript",123,true)
        )
    }
}