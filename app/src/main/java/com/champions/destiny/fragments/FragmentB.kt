package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.champions.destiny.fragments.databinding.FragmentABinding
import com.champions.destiny.fragments.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding: FragmentBBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            toFragmentCbtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToFragmentCClicked()
            }
            backBtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToBackFragmentAClicked()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        fun newInstance() = FragmentB()
    }
}