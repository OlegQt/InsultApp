package com.example.offenseapp.ui.insultscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.offenseapp.databinding.FragmentInsultListBinding
import com.example.offenseapp.databinding.FragmentRootBinding

class InsultListFragment : Fragment() {
    private var binding:FragmentInsultListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsultListBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = requireArguments().getString(ARG_KEY)
        binding?.txtInsultLst?.text = data
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val ARG_KEY = "arg_key"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = InsultListFragment()
    }
}