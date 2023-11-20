package com.champions.destiny.fragments

interface NavigateContactsAppListener {
    fun onMoveToFragmentEditing(id: String, name: String, number: String)
    fun onMoveToFragmentContacts()
}