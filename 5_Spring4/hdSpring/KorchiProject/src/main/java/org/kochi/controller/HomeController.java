package org.kochi.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		// model 객체의 addAttribute() 메소드를 호출해서 데이터를 전달할 수 있다.
		return "home";
	}
	
	@RequestMapping(value="/ajaxHome", method=RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	@RequestMapping(value="/sub/goHome0202", method = RequestMethod.GET)
	public String home0202() {
		logger.info("home0202");
		return "home0202"; // 반환값인 String을 이용해서 home0202.jsp를 불러온다.
	}
	
	@RequestMapping(value="/sub/goHome0203", method = RequestMethod.GET)
	public String home0203() {
		logger.info("home0203");
		return "sub/home0203"; // 반환값이 sub/ 이므로 views폴더에 sub 폴더에 있는  home0203을 불러온다.
	}
	
	@RequestMapping(value="/sub/goHome0204", method = RequestMethod.GET)
	public String home0204() {
		logger.info("home0204");
		return "redirect:/sub/goHome0203"; // redirect:로 시작하면 리다이렉트 방식으로 처리한다.
	}
	
	@RequestMapping(value="/sub/goHome0205", method = RequestMethod.GET)
	public String home0205() {
		logger.info("home0205");
		return "/sub/home0205"; // /로 시작하면 어플리케이션 컨텍스트 경로에 영향을 받지 않는 절대경로를 의미한다.
	}
	
	// 자바 빈즈 클래스 타입 - JSON 객체 타입의 데이터를 만들어서 반환한다.
	// 설정하려면 @ResponseBody 어노테이션을 사용하거나, 클래스에 @RestController 어노테이션을 추가해주어야한다.
	
	@ResponseBody
	@RequestMapping(value="/goHome0301", method = RequestMethod.GET)
	public Member home0301() {
		logger.info("home0301 comming");
		Member member = new Member();
		
		return member; // 반환값이 객체가 된다면 자동으로 객체타입을 반환해준다.
	}
	
	
	@ResponseBody
	@RequestMapping(value="/goHome04", method = RequestMethod.GET)
	public List<Member> home04() {
		logger.info("home04");
		List<Member> list = new ArrayList<Member>();
		list.add(new Member());
		list.add(new Member());
		return list; // 반환값이 컬렉션 List 타입이라면 JSON 객체 배열 타입으로 자동으로 변환된다.
	}
	
	@ResponseBody
	@RequestMapping(value="/goHome05", method = RequestMethod.GET)
	public Map<String, Member> home05() {
		logger.info("home05");
		Map<String, Member> map = new HashMap<String, Member>();
		map.put("key1", new Member());
		map.put("key2", new Member());
		map.put("key3", new Member());
		return map; // 반환값이 컬렉션 Map 타입이라면 JSON 객체 배열 타입으로 자동으로 변환된다.
	}
	
	@ResponseBody
	@RequestMapping(value="/goHome06", method = RequestMethod.GET)
	public ResponseEntity<Void> home06() {
		logger.info("home06");
		return new ResponseEntity<Void>(HttpStatus.OK); // Http 헤더 정보를 통해서 200 OK 상태코드를 전송한다.
	}
	
	@ResponseBody
	@RequestMapping(value="/goHome07", method = RequestMethod.GET)
	public ResponseEntity<String> home07() {
		logger.info("home07");
		return new ResponseEntity<String>("SUCCESS",HttpStatus.OK); 
		// Http 헤더 정보를 통해서 "SUCCESS"메세지와 함께 200 OK 상태코드를 전송한다.
	}
	
	@ResponseBody
	@RequestMapping(value="/goHome08", method = RequestMethod.GET)
	public ResponseEntity<Member> home08() {
		logger.info("home08");
		Member member = new Member();
		return new ResponseEntity<Member>(member,HttpStatus.OK); 
		// Http 헤더 정보를 통해서 객체 JSON 타입의 데이터와 함께 200 OK 상태코드를 전송한다.
	}
	
	// Response시에 Http 헤더 정보와 바이너리 파일 데이터를 전달하는 용도로 사용된다.
	@ResponseBody
	@RequestMapping(value="/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1101() throws Exception {
		logger.info("home1101");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("C:\\nukige.jpg"); // 스트림에 경로에 들어가있는 이미지 파일을 등록한다.
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity; // 바이트 배열로 이미지 파일의 데이터를 전송한다.
	}
	
	
}
