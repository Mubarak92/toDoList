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
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    var binding: FragmentAddBinding? = null
    private val sharedViewModel: MyViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        pickDate()
    }

    private fun pickDate() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                .setTitleText("Select date")
                .build()

        datePicker.show(parentFragmentManager, "tag");
        datePicker.addOnPositiveButtonClickListener {
            convertMillisecondsToReadableDate(it, "EEE, MMM d ")
        }
    }
    private fun convertMillisecondsToReadableDate (dateMilliseconds: Long, datePattern: String): String{
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
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
        val title = binding?.titletask1?.text
        val decript = binding?.decript1?.text
        val date = binding?.setDate1?.text
        var done = binding?.checkBox2?.isChecked
        sharedViewModel.addtask(tasksData(titalTask = title, descriptText = decript, setdate = date,isDone = true))
        findNavController().navigate(R.id.action_add_To_lists)
    }

    fun removeTask(){

    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }

}