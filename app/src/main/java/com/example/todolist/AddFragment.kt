package com.example.todolist

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentAddBinding
import java.util.*


class AddFragment : Fragment(),DatePickerDialog.OnDateSetListener {

    var binding: FragmentAddBinding? = null
    private val sharedViewModel: MyViewModel by activityViewModels()

    var day = 0
    var month = 0
    var year = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        pickDate()
    }
    private fun getDate(){
        val cal: Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }
    private fun pickDate(){


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBining = FragmentAddBinding.inflate(inflater, container, false)
        binding = fragmentBining
        return fragmentBining.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            addFragment = this@AddFragment


        }

    }

    fun addTask() {
        val title = binding?.titletask?.text
        val decript = binding?.decript?.text
    sharedViewModel.addtask(tasksData(titalTask = title, descriptText = decript.toString()))
        findNavController().navigate(R.id.action_add_To_lists)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }

}