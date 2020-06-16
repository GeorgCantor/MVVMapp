package com.example.mvvmapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        bottom_nav_view.setOnNavigationItemSelectedListener(itemSelectedListener)
    }
}
