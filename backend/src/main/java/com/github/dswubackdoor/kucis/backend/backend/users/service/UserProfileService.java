package com.github.dswubackdoor.kucis.backend.backend.users.service;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileResponse getProfile(Long userId) {
        UserProfile profile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("PROFILE_NOT_FOUND", "사용자 프로필이 존재하지 않습니다."));
        return new UserProfileResponse(profile);
    }
}

public UserProfileResponse updateProfile(Long userId, UserProfileUpdateRequest req) {
    UserProfile profile = userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new NotFoundException("PROFILE_NOT_FOUND", "사용자 프로필이 존재하지 않습니다."));

    if (StringUtils.hasText(req.getNickname())) {
        profile.setNickname(req.getNickname());
    }
    if (StringUtils.hasText(req.getAvatarUrl())) {
        profile.setAvatarUrl(req.getAvatarUrl());
    }
    if (StringUtils.hasText(req.getBio())) {
        profile.setBio(req.getBio());
    }

    profile.setUpdatedAt(LocalDateTime.now());
    userProfileRepository.save(profile);

    return new UserProfileResponse(profile);
}
