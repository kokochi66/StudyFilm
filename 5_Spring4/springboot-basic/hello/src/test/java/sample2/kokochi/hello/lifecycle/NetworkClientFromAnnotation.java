package sample2.kokochi.hello.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClientFromAnnotation {

    private String url;

    public NetworkClientFromAnnotation() {
        System.out.println("생성자 호출, url = " + url);
        connect();  // 서비스 연결
        call("초기화 연결 메세지"); // 함수 불러옴
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시, 호출되는 메소드
    public void connect() {
        System.out.println("connect :: " + url);
    }

    public void call(String msg) {
        System.out.println("call : " + url +" , message = " + msg);
    }

    // 서비스 종료시 호출되는 메소드
    public void disconnect() {
        System.out.println("close :: " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("close :: " + url);
        disconnect();
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("afterPropertiesSet");
        connect();  // 서비스 연결
        call("초기화 연결 메세지"); // 함수 불러옴
    }
    // 스프링에서 가장 권장되는 방법으로, 어노테이션 하나만 붙이면 되므로 아주 편리하게 사용할 수 있다.
}
