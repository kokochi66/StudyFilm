package com.kokochi.tech.jenkins.controller.image.model;

import com.kokochi.tech.jenkins.domain.product.enumType.ProductImgType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ImageDto {

    private Long productImageId;
    private Long productId;
    private ProductImgType productImgType;
    private String productImgTitle;
    private String productImgUrl;

    private MultipartFile imageFile;
}
