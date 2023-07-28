
package com.kokochi.study.FilmProject.repository;

import com.kokochi.study.FilmProject.domain.CategoryVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<CategoryVO, String> {
    List<CategoryVO> findByCategoryName(String categoryName);       // 가수이름으로 찾기
    List<CategoryVO> findByItemList(String str);


    List<CategoryVO> findByItemListAfter(String str);
    List<CategoryVO> findByItemListBefore(String str);

    List<CategoryVO> findByItemListContaining(String str);
    List<CategoryVO> findByItemListContains(String str);
    List<CategoryVO> findByItemListNotContains(String str);

    List<CategoryVO> findByItemListEndingWith(String str);
    List<CategoryVO> findByItemListEndsWith(String str);
    List<CategoryVO> findByItemListExists(String str);
}
