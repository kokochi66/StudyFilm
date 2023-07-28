package com.kokochi.study.FilmProject.memo.service;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardVO;
import com.kokochi.study.FilmProject.memo.domain.MemoBoardMasterVO;
import com.kokochi.study.FilmProject.memo.repo.MemoBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memoBoardService")
@Log4j2
@RequiredArgsConstructor
public class MemoBoardService {

    private final MemoBoardRepository memoBoardRepository;

    public List<MemoBoardVO> getMemoBoardListFromMasterId(Long masterId) {
        return memoBoardRepository.findAllByMasterId(masterId);
    }

    public MemoBoardVO getMemoBoard(Long id) {
        return memoBoardRepository.findById(id).get();
    }

    public void addMemoBoard(MemoBoardVO memoBoardVO) {
        memoBoardRepository.save(memoBoardVO);
    }

    public void updateMemoBoard(MemoBoardVO memoBoardVO) {
        memoBoardRepository.updateBoard(memoBoardVO);
    }

    public void deleteMemoBoard(Long id) {
        memoBoardRepository.deleteById(id);
    }


}
