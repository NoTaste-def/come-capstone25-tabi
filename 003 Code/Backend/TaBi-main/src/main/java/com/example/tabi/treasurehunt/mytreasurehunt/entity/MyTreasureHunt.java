package com.example.tabi.treasurehunt.mytreasurehunt.entity;

import com.example.tabi.appuser.entity.AppUser;
import com.example.tabi.util.PostStatus;
import com.example.tabi.treasurehunt.treasurehuntpost.entity.TreasureHuntPost;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class MyTreasureHunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myTreasureHuntId;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    // 양방향 구성 (포스트 작성시 내가 쓴 포스트는 MyTreasureHunt를 생성해줘야함.)
    @ManyToOne
    @JoinColumn(name = "treasure_hunt_post_id")
    private TreasureHuntPost treasureHuntPost;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
