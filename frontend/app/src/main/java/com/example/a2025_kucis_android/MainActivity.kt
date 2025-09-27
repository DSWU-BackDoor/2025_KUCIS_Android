package com.example.a2025_kucis_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, WriteActivity::class.java)
        startActivity(intent)

        finish()
    }
}