package com.kokochi.study.FilmProject.memo.repo;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardMasterVO;
import com.kokochi.study.FilmProject.memo.domain.MemoBoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memoBoardMasterRepository")
public interface MemoBoardMasterRepository extends JpaRepository<MemoBoardMasterVO, Long> {
}
