package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.champions.destiny.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var isBackPressed = false
    private var _binding: FragmentABinding? = null
    private val binding: FragmentABinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            toFragmentBbtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToFragmentBClicked()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"
        fun newInstance() = FragmentA()
    }

}