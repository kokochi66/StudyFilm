
package com.kokochi.study.FilmProject.repository;

import com.kokochi.study.FilmProject.domain.MusicVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<MusicVO, String> {
    List<MusicVO> findByVocal(String vocal);       // 가수이름으로 찾기
    List<MusicVO> findByTitle(String title);       // 노래제목으로 찾기


    List<MusicVO> findByVocalContaining(String vocal);
    List<MusicVO> findByTitleContaining(String title);

    List<MusicVO> findByCategoryList(String str);
    List<MusicVO> findByCategoryListAfter(String str);
    List<MusicVO> findByCategoryListBefore(String str);
    List<MusicVO> findByCategoryListContaining(String str);
    List<MusicVO> findByCategoryListContains(String str);
    List<MusicVO> findByCategoryListNotContains(String str);
    List<MusicVO> findByCategoryListEndingWith(String str);
    List<MusicVO> findByCategoryListEndsWith(String str);
    List<MusicVO> findByCategoryListExists(String str);
}
