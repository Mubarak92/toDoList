package com.example.todolist

import android.text.Editable
import java.text.DateFormat

data class tasksData(
    var titalTask: Editable?,
    var descriptText: Editable?,
    var setdate: Editable?,
    var isDone: Boolean = false,

)



