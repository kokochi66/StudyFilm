package com.kokochi.study.FilmProject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FileVO {
    private String id;
    private String originName;
    private String extension;
    private Long size;

    public MusicVO fileToMusic() {
        MusicVO musicVO = new MusicVO();
        if(this.id != null)             musicVO.setId(this.id);
        if(this.originName != null)     musicVO.setFileName(this.originName);
        if(this.extension != null)      musicVO.setExtension(this.extension);
        if(this.size != null)           musicVO.setSize(this.size);
        return musicVO;
    }

}
