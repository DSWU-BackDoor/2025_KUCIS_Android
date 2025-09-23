package com.github.dswubackdoor.kucis.backend.backend.auth.dto;

public class LoginRequest {
    private String email;
    private String password;

    // 기본 생성자 (JSON 파싱용)
    public LoginRequest() {}

    // getter/setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

