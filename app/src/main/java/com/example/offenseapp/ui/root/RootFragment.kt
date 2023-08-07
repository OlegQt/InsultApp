package com.example.offenseapp.ui.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.offenseapp.databinding.FragmentRootBinding

class RootFragment : Fragment() {
    private var binding:FragmentRootBinding? = null
    private var vm = RootFragmentVm()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.insultText.observe(viewLifecycleOwner){
            binding?.insultText?.text = it
        }

        binding?.loadInsult?.setOnClickListener {
            vm.loadNewInsult()
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