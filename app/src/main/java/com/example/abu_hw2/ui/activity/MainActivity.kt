package com.example.abu_hw2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abu_hw2.R
import com.example.abu_hw2.ui.fragment.LoveFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoveFragment())
                .commit()
        }
    }
}