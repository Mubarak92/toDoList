package com.example.todolist


import android.graphics.Insets.add
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
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


    fun setTaskTitle(TaskTitle: String) {
        _edittask.value = TaskTitle
    }

    fun setDescript(Descript: String){
        _descript.value = Descript
    }


    fun addtask(newdata:tasksData){
        tasklist.add(newdata)

    }
    fun removetask(newdata: tasksData){
        tasklist.removeAll(listOf(newdata))
    }
    fun newTask(task: String) {
        _edittask.value = ""
        _descript.value = ""
        _date.value = 0

    }

//    init {
//        newTask(task)
//    }

}