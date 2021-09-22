package sample2.kokochi.hello.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClientFromInitalizingBean implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClientFromInitalizingBean() {
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

    @Override
    public void destroy() throws Exception {
        System.out.println("close :: " + url);
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        connect();  // 서비스 연결
        call("초기화 연결 메세지"); // 함수 불러옴
    }
    // 스프링 전용 인터페이스로, 외부 라이브러리 적용이 불간으하고, 초기화, 소멸 메서드의 이름을 변경할 수 없다는 단점이 있음.
    // 스프링 초창기에 사용되던 방법으로, 지금은 별로 사용되지 않음.
}
