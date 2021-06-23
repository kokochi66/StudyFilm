package org.hdcd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Item2;
import org.hdcd.service.ItemService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/item2")
public class ItemController2 {

	private static final Logger logger = LoggerFactory.getLogger(ItemController2.class);

	@Autowired
	private ItemService2 itemService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		List<Item2> itemList = this.itemService.list();

		model.addAttribute("itemList", itemList);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute(new Item2());

		return "item2/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		for(int i=0;i<pictures.size();i++) {
			MultipartFile file = pictures.get(i);
			
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("contentType: " + file.getContentType());
			
			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			if(i == 0) item.setPictureUrl(createdFileName);
			if(i == 1) item.setPictureUrl2(createdFileName);
		}
		this.itemService.regist(item);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "item2/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm(Integer itemId, Model model) throws Exception {
		Item2 item = this.itemService.read(itemId);
		model.addAttribute(item);

		return "item2/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		for(int i=0;i<pictures.size();i++) {
			MultipartFile file = pictures.get(i);
			
			if (file != null && file.getSize() > 0) {
				logger.info("originalName: " + file.getOriginalFilename());
				logger.info("size: " + file.getSize());
				logger.info("contentType: " + file.getContentType());

				String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());

				if(i == 0) item.setPictureUrl(createdFileName);
				if(i == 1) item.setPictureUrl2(createdFileName);
			}
			
		}
		this.itemService.modify(item);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "item2/success";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeForm(Integer itemId, Model model) throws Exception {
		Item2 item = this.itemService.read(itemId);

		model.addAttribute(item);

		return "item2/remove";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Item2 item, Model model) throws Exception {
		this.itemService.remove(item.getItemId());

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "item2/success";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();

		String createdFileName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, createdFileName);

		FileCopyUtils.copy(fileData, target);

		return createdFileName;
	}

	@ResponseBody
	@RequestMapping("/display")
	public ResponseEntity<byte[]> displayFile(Integer itemId) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		String fileName = itemService.getPicture(itemId);

		logger.info("FILE NAME1: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + File.separator + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping("/display2")
	public ResponseEntity<byte[]> displayFile2(Integer itemId) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture2(itemId);
		
		logger.info("FILE NAME2: " + fileName);
		
		try {
			
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + fileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	private MediaType getMediaType(String formatName){
		if(formatName != null) {
			if(formatName.equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
			
			if(formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			
			if(formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		
		return null;
	}
	
}
