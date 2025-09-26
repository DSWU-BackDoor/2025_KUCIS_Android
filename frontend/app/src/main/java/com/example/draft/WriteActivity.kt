package com.example.draft

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.draft.databinding.ActivityWriteBinding // ViewBinding 사용을 위해 추가

class WriteActivity : AppCompatActivity() {

    // ViewBinding 사용을 위한 선언
    private lateinit var binding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding 인스턴스 생성
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 저장 버튼 클릭 리스너 설정
        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                // 게시글 저장 로직 (예: 서버에 전송, DB에 저장 등)
                Toast.makeText(this, "게시글이 저장되었습니다.", Toast.LENGTH_SHORT).show()
                // TODO: 실제 저장 로직 구현
            } else {
                Toast.makeText(this, "제목과 내용을 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 로그아웃 버튼 클릭 리스너 설정
        binding.logoutButton.setOnClickListener {
            Toast.makeText(this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
            // TODO: 로그아웃 로직 구현
        }

        // 하단 내비게이션 바 클릭 리스너 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.write // 현재 화면이 Write임을 표시
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // TODO: Home Activity로 이동하는 로직
                    true
                }
                R.id.write -> {
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