package com.kokochi.study.FilmProject.service;

import com.kokochi.study.FilmProject.domain.MusicVO;

import java.util.List;

public interface MusicService {
    MusicVO musicGetById(String id) throws  Exception;
    List<MusicVO> musicGetByCategory(String category) throws  Exception;
    List<MusicVO> musicGetBySearch(String searchKey) throws  Exception;
    void musicAdd(MusicVO musicVO) throws  Exception;
    void musicEdit(MusicVO musicVO) throws  Exception;
    void musicRemove(MusicVO musicVO) throws  Exception;
}
