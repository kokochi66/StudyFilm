package com.kokochi.study.FilmProject.service.impl;

import com.kokochi.study.FilmProject.domain.MusicVO;
import com.kokochi.study.FilmProject.repository.MusicRepository;
import com.kokochi.study.FilmProject.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("musicService")
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public MusicVO musicGetById(String id) throws Exception {
        return musicRepository.findById(id).get();
    }

    @Override
    public List<MusicVO> musicGetByCategory(String category) throws Exception {
        return musicRepository.findByCategoryListContaining(category);
    }

    @Override
    public List<MusicVO> musicGetBySearch(String searchKey) throws Exception {
        List<MusicVO> byVocalContaining = musicRepository.findByVocalContaining(searchKey);
        List<MusicVO> byTitleContaining = musicRepository.findByTitleContaining(searchKey);
        byVocalContaining.addAll(byTitleContaining);
        return byTitleContaining;
    }

    @Override
    public void musicAdd(MusicVO musicVO) throws Exception {
        musicRepository.insert(musicVO);
    }

    @Override
    public void musicEdit(MusicVO musicVO) throws Exception {
        musicRepository.save(musicVO);
    }

    @Override
    public void musicRemove(MusicVO musicVO) throws Exception {
        musicRepository.delete(musicVO);
    }


}
