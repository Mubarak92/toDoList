package com.example.todolist

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentAddBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.lang.reflect.Array.set
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

     var calendar = ""
    var binding: FragmentAddBinding? = null
    private val sharedViewModel: MyViewModel by activityViewModels()

    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {

         calendar=   readDate(it, "EEE, MMM dd ")
            binding?.setDate1?.setText(calendar)

        }


    }
    private fun readDate (setDate: Long, datePattern: String): String{
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(setDate))
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
//checkBox2.isChecked = viewModel.isDone
            checkBox2.jumpDrawablesToCurrentState()

        }

    }

    fun addTask() {
        val title = binding?.titletask1?.text
        val decript = binding?.decript1?.text
        val date = binding?.setDate1?.text
        var done = binding?.checkBox2?.isChecked
        sharedViewModel.addtask(
            tasksData(
                titalTask = title,
                descriptText = decript,
                setdate = date,
                isDone = true
            )
        )
        findNavController().navigate(R.id.action_add_To_lists)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}