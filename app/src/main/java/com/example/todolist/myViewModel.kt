package com.example.todolist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class myViewModel: ViewModel() {
    private val _task = MutableLiveData<String>()
    val task: LiveData<String> = _task

    private val _descript = MutableLiveData<String>()
    val descript: LiveData<String> = _descript


}