package com.kokochi.study.FilmProject.memo.service;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardMasterVO;
import com.kokochi.study.FilmProject.memo.repo.MemoBoardMasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemoBoardMasterService {

    private final MemoBoardMasterRepository memoBoardMasterRepository;

    // 게시판 추가하기 처리
    public void addMemoBoardMaster(MemoBoardMasterVO memoBoardMasterVO) {
        memoBoardMasterRepository.save(memoBoardMasterVO);
    }

    // 게시판 수정하기 처리
    public void updateMemoBoardMaster(MemoBoardMasterVO memoBoardMasterVO) {
        memoBoardMasterRepository.save(memoBoardMasterVO);
    }

    // 게시판 삭제하기 처리
    public void deleteMemoBoardMaster(Long id) {
        memoBoardMasterRepository.deleteById(id);
    }

    // 게시판 가져오기 처리
    public MemoBoardMasterVO getMemoBoardMaster(Long id) {
        return memoBoardMasterRepository.findById(id).get();
    }

    // 게시판 목록 가져오기 처리
    public List<MemoBoardMasterVO> getMemoBoardMasterList() {
        return memoBoardMasterRepository.findAll();
    }

    // 게시판 목록 가져오기 이름 순
    public List<MemoBoardMasterVO> getMemoBoardMasterListOrderByABC() {
        return memoBoardMasterRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }




}
