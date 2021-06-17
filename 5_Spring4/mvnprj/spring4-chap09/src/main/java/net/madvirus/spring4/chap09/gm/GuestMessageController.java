package net.madvirus.spring4.chap09.gm;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageController {

	@RequestMapping(value = "/guestmessage/list.xml")
	@ResponseBody
	// list.xml에 접근하는 경우에 보여주는 값을 JAXB2가 적용된 클래스인 GuestMessageList 타입으로 반환해준다.
	// 이를 통해서 XML응답을 출력해줄 수 있다.
	public GuestMessageList listXml() {
		return getMessageList();
	}

	@RequestMapping(value = "/guestmessage/post.xml", method = RequestMethod.POST)
	@ResponseBody
	public GuestMessageList postXml(@RequestBody GuestMessageList messageList) {
		return messageList;
	}

	private GuestMessageList getMessageList() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메시지", new Date()),
				new GuestMessage(2, "메시지2", new Date())
				);

		return new GuestMessageList(messages);
	}

	@RequestMapping(value = "/guestmessage/list.json")
	@ResponseBody
	public GuestMessageList2 listJson() {
		return getMessageList2();
	}	// Jackson2설정만 되어있다면 해당 파일을 그대로 넘기면 바로 JSON파일로 변화되어 화면에 표시해준다.

	private GuestMessageList2 getMessageList2() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메시지", new Date()),
				new GuestMessage(2, "메시지2", new Date())
				);

		return new GuestMessageList2(messages);
	}
}
