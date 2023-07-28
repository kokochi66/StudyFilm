package com.kokochi.study.FilmProject.globalDomain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class UserVO {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Memo_board_GEN"
    )
    private Long id;                        // PK 값

    @Column(nullable = false)
    private String name;                    // 사용자 이름

    @Column(nullable = false)
    private String userId;                  // 사용자 Id

    @Column(nullable = false)
    private String password;                // 사용자 비밀번호

    private String email;                   // 사용자 이메일

    private String mobile;                  // 사용자 핸드폰 번호

}

