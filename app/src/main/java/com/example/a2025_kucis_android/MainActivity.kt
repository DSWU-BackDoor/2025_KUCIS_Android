 package com.example.a2025_kucis_android

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrowButton: ImageButton = findViewById(R.id.arrow)
        val logoutButton: Button = findViewById(R.id.logout)
        val editButton: ImageButton = findViewById(R.id.edit)
        val deleteButton: ImageButton = findViewById(R.id.delete)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        arrowButton.setOnClickListener {
            finish()
        }

        logoutButton.setOnClickListener {

        }

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_write -> {
                    true
                }
                R.id.navigation_settings -> {
                    true
                }
                else -> false
            }
        }

    }
}
