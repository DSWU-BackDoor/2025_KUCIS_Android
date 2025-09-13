package com.github.dswubackdoor.kucis.backend.backend.auth.dto;

public class SignUpRequest {
    private String email;
    private String password;
    private String nickname;

    public SignUpRequest() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}

