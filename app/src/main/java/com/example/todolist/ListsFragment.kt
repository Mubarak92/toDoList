package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.Itemadapter.ItemAdapter
import com.example.todolist.databinding.FragmentListsBinding


class ListsFragment : Fragment() {
    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = ItemAdapter(this, context)
        binding.addTask.setOnClickListener {

val action = ListsFragmentDirections.actionListsFragmentToAddFragment()
findNavController().navigate(action)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}