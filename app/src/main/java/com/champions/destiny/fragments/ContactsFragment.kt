package com.champions.destiny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.champions.destiny.fragments.EditingFragment.Companion.FRAGMENT_EDITING_TAG
import com.champions.destiny.fragments.EditingFragment.Companion.ID
import com.champions.destiny.fragments.EditingFragment.Companion.NAME
import com.champions.destiny.fragments.EditingFragment.Companion.NUMBER
import com.champions.destiny.fragments.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(), ContactClickListener {
    private var _binding: FragmentContactsBinding? = null
    private val binding: FragmentContactsBinding
        get() = _binding!!
    private val adapter = ModifyCompositeDelegateAdapter(
        ContactDelegateAdapter(this)
    )
    private val itemTouchHelper = ItemTouchHelper(ContactItemTouchHelperCallback(adapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dividerItemDecoration =
            DividerItemDecoration(binding.recyclerView.context, DividerItemDecoration.VERTICAL)
        setFragmentResultListener(FRAGMENT_EDITING_TAG) { _, bundle ->
            val id = bundle.getString(ID)
            val name = bundle.getString(NAME)
            val number = bundle.getString(NUMBER)
            ContactsDataFactory.replaceContact(
                Contact(
                    id!!.toInt(),
                    name!!,
                    number!!
                )
            )
        }
        with(binding) {
            itemTouchHelper.attachToRecyclerView(recyclerView)
            recyclerView.addItemDecoration(dividerItemDecoration)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            adapter.swapData(ContactsDataFactory.getData())
            deleteBtn.setOnClickListener {
                adapter.swapData(ContactsDataFactory.updateCheckboxVisibilityContact(true))
                cancelBtn.visibility = View.VISIBLE
                confirmBtn.visibility = View.VISIBLE
                deleteBtn.visibility = View.INVISIBLE
            }
            cancelBtn.setOnClickListener {
                adapter.swapData(ContactsDataFactory.updateCheckboxVisibilityContact(false))
                cancelBtn.visibility = View.INVISIBLE
                confirmBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.VISIBLE
            }
            confirmBtn.setOnClickListener {
                adapter.swapData(ContactsDataFactory.deleteContacts())
                adapter.swapData(ContactsDataFactory.updateCheckboxVisibilityContact(false))
                cancelBtn.visibility = View.INVISIBLE
                confirmBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onContactClicked(contact: Contact) {
        adapter.swapData(ContactsDataFactory.updateCheckboxVisibilityContact(false))
        (requireActivity() as NavigateContactsAppListener).onMoveToFragmentEditing(
            contact.id.toString(),
            contact.name,
            contact.telephoneNumber
        )
    }

    companion object {
        const val FRAGMENT_CONTACTS_TAG = "FRAGMENT_CONTACTS_TAG"
        fun newInstance() = ContactsFragment()
    }

}