package net.madvirus.spring4.chap09.gm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list")
// JAXB2를 이용해서 GuestMessageList 객체를 XML로 변환하면 루트 태그가 <message-list>인 XML이 생성된다.
public class GuestMessageList {

	@XmlElement(name = "message")
	private List<GuestMessage> messages;

	public GuestMessageList() {
	}

	public GuestMessageList(List<GuestMessage> messages) {
		this.messages = messages;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}

}
