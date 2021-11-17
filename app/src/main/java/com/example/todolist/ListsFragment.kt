package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.Itemadapter.ItemAdapter
import com.example.todolist.databinding.FragmentListsBinding


class ListsFragment : Fragment() {
    private var binding: FragmentListsBinding? = null
    private val sharedViewModel: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentListsBinding = FragmentListsBinding.inflate(inflater, container, false)

        binding = fragmentListsBinding
        return fragmentListsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)


        binding?.recyclerview!!.adapter = ItemAdapter(this, context)
        binding?.addTask!!.setOnClickListener {

val action = ListsFragmentDirections.actionListsFragmentToAddFragment()
findNavController().navigate(action)
        }

    }

    fun removeTask(){

        val title = binding?.recyclerview.toString()

    }

//    fun removetask() {
//        sharedViewModel.removetask(isRemoving.
//        findNavController().navigate(R.id.action_add_To_lists)
//    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }
}