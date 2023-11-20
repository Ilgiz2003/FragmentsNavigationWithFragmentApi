package com.champions.destiny.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.champions.destiny.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            task1Btn.setOnClickListener {
                startActivity(TaskOneMainActivity.newIntent(this@MainActivity))
            }
            task2Btn.setOnClickListener {
                startActivity(TaskTwoMainActivity.newIntent(this@MainActivity))
            }
        }

    }
}