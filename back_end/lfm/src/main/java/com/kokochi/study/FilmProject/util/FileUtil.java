package com.kokochi.study.FilmProject.util;

import com.kokochi.study.FilmProject.domain.FileVO;
import com.kokochi.study.FilmProject.domain.MusicVO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileUtil {
    public void uploadMusic(MultipartHttpServletRequest request, MusicVO musicVO) throws Exception;
    public FileVO uploadFile(MultipartHttpServletRequest request, MultipartFile multipartFile, String id);
}
