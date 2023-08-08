package com.example.offenseapp.ui.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.offenseapp.R
import com.example.offenseapp.databinding.FragmentRootBinding
import com.example.offenseapp.ui.insultscreen.InsultListFragment

class RootFragment : Fragment() {
    private var binding: FragmentRootBinding? = null
    private lateinit var vm: RootFragmentVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(inflater, container, false)
        vm = ViewModelProvider(this)[RootFragmentVm()::class.java]

        vm.insultText.observe(viewLifecycleOwner) {
            binding?.insultText?.text = it
        }

        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.loadInsult?.setOnClickListener {
            vm.loadNewInsult()
        }

        binding?.buttonNavigateToList?.setOnClickListener {
            findNavController().navigate(
                R.id.action_rootFragment_to_insultListFragment,
                Bundle().apply { putString(InsultListFragment.ARG_KEY, binding?.insultText?.text.toString()) }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = RootFragment()
    }
}