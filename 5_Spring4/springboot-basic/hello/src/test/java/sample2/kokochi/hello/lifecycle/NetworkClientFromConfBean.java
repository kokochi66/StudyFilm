package sample2.kokochi.hello.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClientFromConfBean{

    private String url;

    public NetworkClientFromConfBean() {
        System.out.println("생성자 호출, url = " + url);
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

    }

    public void init() throws Exception {
        System.out.println("close :: " + url);
        disconnect();
    }

    public void close() throws Exception {
        System.out.println("afterPropertiesSet");
        connect();  // 서비스 연결
        call("초기화 연결 메세지"); // 함수 불러옴
    }
    // 메소드 이름을 자유롭게 준 뒤, 빈에서 초기화 메소드와 제거 메소드를 직접 지정해주는 방법이다.
    // @Bean의 destroyMethod는 close shutdown이라는 이름이 기본 종료 메소드값으로 지정되어, 별도로 지정해주지 않아도 된다.
}
