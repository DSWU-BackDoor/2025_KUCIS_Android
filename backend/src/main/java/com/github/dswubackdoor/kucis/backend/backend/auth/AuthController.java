package com.github.dswubackdoor.kucis.backend.backend.auth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.github.dswubackdoor.kucis.backend.backend.auth.dto.LoginRequest;
import com.github.dswubackdoor.kucis.backend.backend.auth.dto.SignUpRequest;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 로그인 처리 로직
        return ResponseEntity.ok().body("login success");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        // 회원가입 처리 로직
        return ResponseEntity.status(HttpStatus.CREATED).body("signup success");
    }
}
