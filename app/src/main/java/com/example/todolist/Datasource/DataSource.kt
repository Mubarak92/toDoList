package com.example.todolist.Datasource

import com.example.todolist.tasksData

class DataSource {

    fun tasks(): List<tasksData> {
return tasklist
    }
}
fun deleteTask(searchingTitle:String){
    tasklist.removeIf { it.titalTask.toString()==searchingTitle }
}
var tasklist:MutableList<tasksData> = mutableListOf()