package com.champions.destiny.fragments

data class Contact(
    var id: Int,
    var name: String,
    var telephoneNumber: String,
    var isCheckboxVisible: Boolean = false,
    var isCheckboxChecked: Boolean = false
)
