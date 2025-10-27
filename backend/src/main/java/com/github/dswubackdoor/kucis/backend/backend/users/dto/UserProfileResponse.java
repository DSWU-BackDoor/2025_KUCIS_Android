package com.github.dswubackdoor.kucis.backend.backend.users.dto;

import com.github.dswubackdoor.kucis.backend.backend.domain.User;

public class UserProfileResponse {
    private String nickname;
    private String avatarUrl;
    private String bio;

    public UserProfileResponse(UserProfile profile) {
        this.nickname = profile.getNickname();
        this.avatarUrl = profile.getAvatarUrl();
        this.bio = profile.getBio();
    }
}
