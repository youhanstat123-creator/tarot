package com.example.tarot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tarot_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;   // 로그인 ID

    @Column(nullable = false)
    private String password;   // 암호화 비밀번호

    @Column(nullable = false)
    private String name;       // 사용자 이름 (실명)

    private String role;       // ROLE_USER
}
