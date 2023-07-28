package com.kokochi.study.FilmProject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "category")
@Getter
@Setter
@ToString
public class CategoryVO {
    @Id
    private String id;
    private String categoryName;        // 카테고리 이름
    private List<String> ItemList;      // 카데고리에 속하는 파일 리스트
}
