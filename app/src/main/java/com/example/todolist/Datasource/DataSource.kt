package com.example.todolist.Datasource

import com.example.todolist.tasks

class DataSource {
    fun tasks():List<tasks>{
        return listOf<tasks>(
            tasks("Task1","TaskDscript",123,true)
        )
    }
}