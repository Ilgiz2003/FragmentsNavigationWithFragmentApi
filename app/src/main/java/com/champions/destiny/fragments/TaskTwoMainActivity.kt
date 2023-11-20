package com.champions.destiny.fragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.champions.destiny.fragments.ContactsFragment.Companion.FRAGMENT_CONTACTS_TAG
import com.champions.destiny.fragments.EditingFragment.Companion.FRAGMENT_EDITING_TAG

class TaskTwoMainActivity : AppCompatActivity(), NavigateContactsAppListener {
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val currentFragment = supportFragmentManager.fragments.last()
            if(currentFragment is EditingFragment){
                onMoveToFragmentContacts()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_two_main)
        onBackPressedDispatcher.addCallback(callback)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_CONTACTS_TAG) == null) {
            with(supportFragmentManager.beginTransaction()) {
                replace(R.id.contactsContainer, ContactsFragment.newInstance(), FRAGMENT_CONTACTS_TAG)
                commit()
            }
        }
    }

    override fun onMoveToFragmentEditing(id: String, name: String, number: String) {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.contactsContainer, EditingFragment.newInstance(id, name, number),
                FRAGMENT_EDITING_TAG
            )
            commit()
        }
    }

    override fun onMoveToFragmentContacts() {
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.contactsContainer, ContactsFragment.newInstance(), FRAGMENT_CONTACTS_TAG)
            commit()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, TaskTwoMainActivity::class.java)
    }


}