package com.example.kucis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // TabLayout 참조
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        // 탭 항목 추가
        tabLayout.addTab(tabLayout.newTab().setText("Log In"), true) // 첫 번째 탭 선택
        tabLayout.addTab(tabLayout.newTab().setText("Sign Up"))

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        loginBtn.setOnClickListener {
            Toast.makeText(this, "로그인 버튼 클릭됨", Toast.LENGTH_SHORT).show()
        }
    }
}
