package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.champions.destiny.fragments.databinding.FragmentCBinding
import com.champions.destiny.fragments.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private var _binding: FragmentDBinding? = null
    private val binding: FragmentDBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toFragmentBbtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToFragmentBClickedFromFragmentD()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        fun newInstance() = FragmentD()
    }

}