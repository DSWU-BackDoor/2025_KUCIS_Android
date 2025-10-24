package com.github.dswubackdoor.kucis.backend.backend.users.dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileUpdateRequest {
    @Size(max = 30, message = "닉네임은 30자 이하로 입력해야 합니다.")
    private String nickname;

    private String avatarUrl;

    @Size(max = 200, message = "자기소개는 200자 이하로 입력해야 합니다.")
    private String bio;
}

