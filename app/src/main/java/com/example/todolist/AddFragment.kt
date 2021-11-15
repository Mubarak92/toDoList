package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.todolist.databinding.FragmentAddBinding



class AddFragment : Fragment() {

    var binding: FragmentAddBinding? = null
    private val sharedViewModel: myViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

val fragmentBining = FragmentAddBinding.inflate(inflater,container,false)
        binding = fragmentBining
        return fragmentBining.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

//lifecycleOwner = viewLifecycleOwner
//            viewModel = sharedViewModel
//            addFragment = this@AddFragment


        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}