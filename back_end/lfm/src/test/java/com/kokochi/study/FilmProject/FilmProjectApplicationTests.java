package com.kokochi.study.FilmProject;

import com.kokochi.study.FilmProject.domain.MusicVO;
import com.kokochi.study.FilmProject.repository.MusicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class FilmProjectApplicationTests {

	@Autowired
	MusicRepository musicRepository;

	@Test
	void musicadd() {
//		MusicVO musicVO = new MusicVO();
//		musicVO.setTitle("Last Stardust");
//		musicVO.setVocal("Aimer");
//		musicRepository.insert(musicVO);

		List<MusicVO> aimer = musicRepository.findByVocalContaining("Aimer");
		for (MusicVO vo : aimer) {
			System.out.println("TEST :: " + vo);
		}
	}

}
