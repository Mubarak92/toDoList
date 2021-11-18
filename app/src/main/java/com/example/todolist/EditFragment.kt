package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentEditBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class EditFragment : Fragment() {
    var calendar = ""
    var _binding: FragmentEditBinding? = null
    val binding get() = _binding!!
    private val sharedViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentEditBinding = FragmentEditBinding.inflate(inflater, container, false)
        _binding =fragmentEditBinding
        return fragmentEditBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            editFragment = this@EditFragment

        }
    }

    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {

            calendar= readDate(it, "dd/MM/yyyy")
            binding.setDate1.setText(calendar)

        }

    }
    private fun readDate (setDate: Long, datePattern: String): String{
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(setDate))

    }


    fun edit(){

        val title = binding.titletask1.text
        val decript = binding.decript1.text
        val date = binding.setDate1.text
        var done = binding.checkBox2.isChecked
        var temp = 0
        arguments?.let {
            temp=it?.getInt("index")
        }
        sharedViewModel.edite(temp,tasksData(title,decript,date,done))
        findNavController().navigate(R.id.action_edit_To_lists)

    }

    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}