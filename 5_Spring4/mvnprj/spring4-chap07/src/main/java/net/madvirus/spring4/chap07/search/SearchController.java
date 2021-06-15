package net.madvirus.spring4.chap07.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping("/search")
	public String search(@RequestParam(value = "q", defaultValue="") String query,
			Model model) {
		// @RequestParam의 값이 default값을 요청 파라미터로 대신 넣어서, 요청값이 오지 않았을 때를 대비할 수 있다.
		// 혹은 요청값이 아예 필수가 아니라면 required 속성값을 false로 지정해주면 된다.
		System.out.println("검색어: " + query);
		return "search/result";
	}
}
