package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResult
import com.champions.destiny.fragments.databinding.FragmentEditingBinding

class EditingFragment : Fragment() {
    private var _binding: FragmentEditingBinding? = null
    private val binding: FragmentEditingBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            newName.setText(arguments?.getString(NAME))
            newNumber.setText(arguments?.getString(NUMBER))
            addBtn.setOnClickListener {
                if (newName.text != null && newNumber.text != null) {
                    val bundle = Bundle().apply {
                        putString(ID, arguments?.getString(ID))
                        putString(NAME, newName.text.toString())
                        putString(NUMBER, newNumber.text.toString())
                    }
                    setFragmentResult(FRAGMENT_EDITING_TAG, bundle)
                    (requireActivity() as NavigateContactsAppListener).onMoveToFragmentContacts()
                }
            }
            backBtn.setOnClickListener {
                (requireActivity() as NavigateContactsAppListener).onMoveToFragmentContacts()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val FRAGMENT_EDITING_TAG = "FRAGMENT_EDITING_TAG"
        const val ID = "ID"
        const val NAME = "NAME"
        const val NUMBER = "NUMBER"
        fun newInstance(id: String, name: String, number: String) = EditingFragment().apply {
            arguments = Bundle().apply {
                putString(ID, id)
                putString(NAME, name)
                putString(NUMBER, number)
            }
        }
    }

}