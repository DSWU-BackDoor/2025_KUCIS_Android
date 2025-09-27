package com.example.a2025_kucis_android // 자신의 패키지 이름 확인

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.a2025_kucis_android.databinding.ActivityReadBinding
import android.content.Intent

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // "POST_TITLE"과 "POST_CONTENT"라는 이름으로 전달된 데이터를 받습니다.
        val title = intent.getStringExtra("POST_TITLE")
        val content = intent.getStringExtra("POST_CONTENT")

        // 전달받은 텍스트를 EditText에 채워 넣습니다.
        binding.titleEditText.setText(title)
        binding.contentEditText.setText(content)


        binding.titleEditText.isEnabled = false
        binding.contentEditText.isEnabled = false


        binding.arrowImageButton.setOnClickListener {
            finish()
        }

        binding.logoutButton.setOnClickListener {
            Toast.makeText(this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
            // TODO: 실제 로그아웃 로직 구현 (예: 로그인 화면으로 이동)
        }

        // 수정 버튼
        binding.editButton.setOnClickListener {
            // 수정 페이지(WriteActivity)로 이동하는 로직
            val intent = Intent(this, WriteActivity::class.java)

            // 현재 게시글의 제목과 내용을 EditActivity로 전달
            intent.putExtra("POST_TITLE", title)
            intent.putExtra("POST_CONTENT", content)

            startActivity(intent)
            Toast.makeText(this, "수정 페이지로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

        // 삭제 버튼
        binding.deleteButton.setOnClickListener {
            // TODO: 실제 데이터베이스나 서버에서 게시글을 삭제하는 로직을 구현해야 합니다.
            // TODO: "정말 삭제하시겠습니까?" 같은 확인 다이얼로그를 띄워주는 것이 좋습니다.

            Toast.makeText(this, "게시글이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
            finish() // 삭제 후 현재 화면 종료
        }



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.home // 현재 화면에 맞는 아이콘 활성화

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.write -> {
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