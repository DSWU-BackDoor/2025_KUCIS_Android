package com.example.kucis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
<<<<<<< HEAD:frontend/app/src/main/java/com/github/dswubackdoor/kucis/MainActivity.kt
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.dswubackdoor.kucis.ui.theme.KUCISAndroidTheme
import com.example.kucis.ui.theme.KUCISTheme
data class Message(
    val title: String,
    val preview: String,
    val editCount: Int = 0
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KUCISAndroidTheme {
                MessageListScreen()

            KUCISTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageListScreen() {
    var searchText by remember { mutableStateOf("") }

    // TODO: 다른 개발자가 구현할 글 쓰기 화면과 연동

    // 현재는 빈 리스트로 시작 (실제 데이터는 글 쓰기 화면에서 추가됨)
    val allMessages = remember { mutableStateListOf<Message>() }

    // 검색 필터링
    val filteredMessages = remember(searchText, allMessages.size) {
        if (searchText.isEmpty()) {
            allMessages.toList()
        } else {
            allMessages.filter { message ->
                message.title.contains(searchText, ignoreCase = true) ||
                        message.preview.contains(searchText, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // 상단바
        TopAppBar(
            title = { },
            actions = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 검색 필드
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = { Text("Search") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.Gray
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedContainerColor = Color(0xFFF0F0F0),
                            focusedContainerColor = Color(0xFFF0F0F0)
                        )
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // 로그아웃 버튼
                    Button(
                        onClick = { /* 로그아웃 처리 */ },
                        modifier = Modifier.height(36.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4285F4)
                        )
                    ) {
                        Text(
                            "Log out",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        // 메시지 목록
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(top = 8.dp)
        ) {
            items(filteredMessages) { message ->
                MessageItem(
                    message = message,
                    onClick = {
                        // TODO: 글 내용 페이지로 이동
                    }
                )
            }
        }

        // 하단 네비게이션
        BottomNavigationBar()
    }
}

@Composable
fun MessageItem(
    message: Message,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 프로필 이미지
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFE3F2FD)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color(0xFF4285F4),
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // 텍스트 영역
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = message.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.preview,
                fontSize = 14.sp,
                color = Color(0xFF666666),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(Color.White)
    ) {
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = "Home",
            isSelected = true,
            onClick = { /* Home 클릭 */ }
        )
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = "Write",
                    tint = Color(0xFF999999),
                    modifier = Modifier.size(24.dp)
                )
            },
            label = "Write",
            isSelected = false,
            onClick = {
                // TODO: 다른 개발자가 구현할 글 쓰기 화면으로 이동
                // 예: navController.navigate("writeScreen")
            }
        )
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = "Settings",
                    tint = Color(0xFF999999),
                    modifier = Modifier.size(24.dp)
                )
            },
            label = "Settings",
            isSelected = false,
            onClick = { /* Settings 클릭 */ }
        )
    }
}

@Composable
fun RowScope.BottomNavItem(
    icon: @Composable () -> Unit,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        icon()
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (isSelected) Color(0xFF333333) else Color(0xFF999999)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MessageListScreenPreview() {
    KUCISAndroidTheme {
        MessageListScreen()
fun GreetingPreview() {
    KUCISTheme {
        Greeting("Android")
    }
}
