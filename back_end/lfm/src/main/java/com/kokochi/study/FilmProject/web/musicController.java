package com.kokochi.study.FilmProject.web;

import com.kokochi.study.FilmProject.domain.MusicVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping(value = "/music/")
public class musicController {


    @RequestMapping(value="list", method = RequestMethod.GET)
    public ModelAndView musicList(ModelAndView mav) {
        log.info("music/music_list :: 음악 리스트");
        mav.setViewName("music/music_list");
        return mav;
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public ModelAndView musicAddGet(ModelAndView mav) {
        log.info("music/music_add :: 음악 추가하기");
        mav.setViewName("music/music_add");
        return mav;
    }

    @RequestMapping(value="add/process", method = RequestMethod.POST)
    public String musicAddPost(MusicVO musicVO, ModelAndView mav, MultipartHttpServletRequest request) {
        log.info("music/music_add :: 음악 추가하기 POST :: " + musicVO);

        String uploadPath = request.getSession().getServletContext().getRealPath("/").concat("resources");
        String musicUploadPath = uploadPath + File.separator + "music";

        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            String filename = fileNames.next();
            MultipartFile multipartFile = request.getFile(filename);
                if (!multipartFile.isEmpty()){
                    String originName = multipartFile.getOriginalFilename();
                    String extension = originName.substring(originName.lastIndexOf(".") + 1).toLowerCase();
                    log.info("music :: " + originName +" " +extension+" :: " + musicUploadPath);

                    File musicfile = new File(musicUploadPath, multipartFile.getOriginalFilename());
                    try {
                        multipartFile.transferTo(musicfile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        return "redirect:/";
    }

    @RequestMapping(value="edit", method = RequestMethod.GET)
    public ModelAndView editGet(ModelAndView mav) {
        log.info("/layout :: 레이아웃 테스트");
        return mav;
    }

    @RequestMapping(value="view", method = RequestMethod.GET)
    public ModelAndView viewGet(ModelAndView mav) {
        log.info("/layout :: 레이아웃 테스트");
        return mav;
    }

}
