package com.champions.destiny.fragments

import com.champions.destiny.fragments.Contact
import com.champions.destiny.fragments.ContactsDataFactory
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import com.livermor.delegateadapter.delegate.DelegateAdapter

class ModifyCompositeDelegateAdapter(vararg adapters: DelegateAdapter) :
    CompositeDelegateAdapter(*adapters) {

    fun onItemMove(fromPosition: Int, toPosition: Int): List<Contact> {
        return ContactsDataFactory.swapContacts(fromPosition, toPosition)
    }
}