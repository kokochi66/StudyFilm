package net.madvirus.spring4.chap05;

import java.net.URL;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RestClient {

	private URL serverUrl;
	private Date apiDate;

	public void setServerUrl(URL serverUrl) {
		this.serverUrl = serverUrl;
		// xml파일에서 지정된 값이 URL타입으로 변환되어 저장된다.
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	// 데이터의 패턴에 대해서 어노테이션상에서 직접 지정할 수 있다.
	public void setApiDate(Date apiDate) {
		this.apiDate = apiDate;
	}

	@Override
	public String toString() {
		return "RestClient [serverUrl=" + serverUrl + "]";
	}

}
