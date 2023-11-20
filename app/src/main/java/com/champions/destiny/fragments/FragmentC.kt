package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.champions.destiny.fragments.databinding.FragmentBBinding
import com.champions.destiny.fragments.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private var _binding: FragmentCBinding? = null
    private val binding: FragmentCBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toFragmentAbtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToFragmentAClicked()
            }
            toFragmentDbtn.setOnClickListener {
                (requireActivity() as OnButtonClickListener).onMoveToFragmentDClicked()
            }
            text.text = arguments?.getString(STRING_EXTRA) ?: ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"
        const val STRING_EXTRA = "STRING_EXTRA"
        fun newInstance(string: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(STRING_EXTRA, string)
            }
        }
    }
}