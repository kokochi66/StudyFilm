package com.kokochi.tech.jenkins.domain.product;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImgScorePK implements Serializable {
    private Long productImgId;
    private Long userId;
}
