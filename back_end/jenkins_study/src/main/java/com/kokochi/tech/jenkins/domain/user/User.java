package com.kokochi.tech.jenkins.domain.user;

import com.kokochi.tech.jenkins.domain.product.ProductImgScore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString(of = {"userId", "userName"})
@Table(name = "dss_user")
public class User {

    @Id
    private Long userId;

    private String userName;
    private String password;

    @CreatedDate
    private LocalDateTime regDate;

    @Transient
    private List<ProductImgScore> productImgScoreList = new ArrayList<>();


    public static User createUser(String userName, String password) {
        return User.builder()
                .userName(userName)
                .password(password)
                .regDate(LocalDateTime.now())
                .build();
    }
}
