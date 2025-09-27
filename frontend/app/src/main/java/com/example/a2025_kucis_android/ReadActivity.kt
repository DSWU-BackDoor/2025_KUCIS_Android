package com.example.a2025_kucis_android // 자신의 패키지 이름 확인

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.a2025_kucis_android.databinding.ActivityReadBinding// activity_main.xml에 대한 바인딩
import android.content.Intent

class ReadActivity : AppCompatActivity() {

    // activity_main.xml에 대한 ViewBinding 선언
    private lateinit var binding: ActivityReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding 인스턴스 생성
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 처음에는 EditText들을 수정할 수 없도록 설정 (보기 모드)
        binding.titleEditText.isEnabled = false
        binding.contentEditText.isEnabled = false

        // 뒤로가기 화살표 버튼 클릭 리스너
        binding.arrowImageButton.setOnClickListener {
            finish() // 현재 화면 종료
        }

        // 로그아웃 버튼 클릭 리스너
        binding.logoutButton.setOnClickListener {
            Toast.makeText(this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
            // TODO: 실제 로그아웃 로직 구현 (예: 로그인 화면으로 이동)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.home // 현재 화면에 맞는 아이콘 활성화 (예: home)
        // ReadActivity.kt의 하단 네비게이션 리스너 부분

        // ReadActivity.kt의 하단 네비게이션 리스너 부분

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // TODO: Home Activity(MainActivity)로 이동하는 로직
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.write -> {
                    // TODO: Write Activity로 이동하는 로직
                    val intent = Intent(this, WriteActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.settings -> {
                    // TODO: Settings Activity로 이동하는 로직
                    true
                }
                else -> false
            }
        }
    }
}