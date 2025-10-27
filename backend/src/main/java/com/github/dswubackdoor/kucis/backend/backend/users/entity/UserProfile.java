package com.github.dswbackdoor.kucis.backend.backend.users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // users.id와 매핑되는 1:1 관계
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "nickname", length = 30)
    private String nickname;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "bio", length = 200)
    private String bio;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }
}
