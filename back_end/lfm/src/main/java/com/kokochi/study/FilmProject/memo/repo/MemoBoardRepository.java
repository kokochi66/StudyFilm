package com.kokochi.study.FilmProject.memo.repo;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("memoRepository")
public interface MemoBoardRepository extends JpaRepository<MemoBoardVO, Long> {

    @Query(value = "SELECT mb FROM MemoBoardVO mb WHERE mb.master.id = :masterId")
    List<MemoBoardVO> findAllByMasterId(Long masterId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
            value = "UPDATE MemoBoardVO mb SET mb.title = :#{#memoBoardVO.title}, mb.writer = :#{#memoBoardVO.writer}, mb.contents = :#{#memoBoardVO.contents} WHERE mb.id = :#{#memoBoardVO.id}"
    )
    void updateBoard(MemoBoardVO memoBoardVO);

}
