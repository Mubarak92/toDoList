package com.example.todolist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.Datasource.tasklist

class MyViewModel : ViewModel() {
    private val _titletask = MutableLiveData<String>()
    val titletask: LiveData<String> = _titletask

    private val _edittask = MutableLiveData<String>()
    val edittask: LiveData<String> = _edittask

    private val _descript = MutableLiveData<String>()
    val descript: LiveData<String> = _descript

    private val _date = MutableLiveData<Int>()
    val date: LiveData<Int> = _date

    private val _isDone = MutableLiveData<Int>()
    val isDone: LiveData<Int> = _isDone


    fun setTaskTitle(TaskTitle: String) {
        _edittask.value = TaskTitle
    }

    fun setDescript(Descript: String){
        _descript.value = Descript
    }



    fun addtask(newdata: tasksData){
        tasklist.add(newdata)

    }

    fun removetask(remove: tasksData?){
        tasklist.remove(remove)
    }
    fun newTask(task: String) {
        _edittask.value = ""
        _descript.value = ""
        _date.value = 0

    }


    fun edit(index : Int , newdata:tasksData){
        tasklist.set(index,newdata)
    }


}