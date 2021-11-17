package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentEditBinding

class EditFragment : Fragment() {

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

//        arguments?.let {
//            binding?.decript?.text = it.getString()
//        }

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            editFragment = this@EditFragment


        }



    }

    fun editDecript(){
//
//        val mytitle = binding?.decript?.text.toString()
//        sharedViewModel.setDescript(mytitle)

        findNavController().navigate(R.id.action_edit_To_lists)
    }

//    fun goToNextScreen() {
//        findNavController().navigate(R.id.action_edit_To_lists)
//    }
    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}