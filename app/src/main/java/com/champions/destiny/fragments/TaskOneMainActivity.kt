package com.champions.destiny.fragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import com.champions.destiny.fragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.champions.destiny.fragments.FragmentB.Companion.FRAGMENT_B_TAG
import com.champions.destiny.fragments.FragmentC.Companion.FRAGMENT_C_TAG
import com.champions.destiny.fragments.FragmentD.Companion.FRAGMENT_D_TAG

class TaskOneMainActivity : AppCompatActivity(), OnButtonClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one_main)

        if (supportFragmentManager.findFragmentByTag(FRAGMENT_A_TAG) == null) {
            with(supportFragmentManager.beginTransaction()) {
                replace(R.id.container, FragmentA.newInstance(), FRAGMENT_A_TAG)
                commit()
            }
        }
    }

    override fun onMoveToFragmentBClicked() {
        supportFragmentManager.popBackStack(null, POP_BACK_STACK_INCLUSIVE)
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentB.newInstance(),
                FRAGMENT_B_TAG
            )
            commit()
        }
    }

    override fun onMoveToBackFragmentAClicked() {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentA.newInstance(),
                FRAGMENT_A_TAG
            )
            commit()
        }
    }

    override fun onMoveToFragmentCClicked() {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentC.newInstance("Hello Fragment C"),
                FRAGMENT_C_TAG
            )
            commit()
        }
    }

    override fun onMoveToFragmentAClicked() {
        supportFragmentManager.popBackStack(null, POP_BACK_STACK_INCLUSIVE)
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentA.newInstance(),
                FRAGMENT_A_TAG
            )
            commit()
        }
    }

    override fun onMoveToFragmentDClicked() {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentD.newInstance(),
                FRAGMENT_D_TAG
            )
            commit()
        }
    }

    override fun onMoveToFragmentBClickedFromFragmentD() {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                R.id.container, FragmentB.newInstance(),
                FRAGMENT_B_TAG
            )
            commit()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, TaskOneMainActivity::class.java)
    }
}