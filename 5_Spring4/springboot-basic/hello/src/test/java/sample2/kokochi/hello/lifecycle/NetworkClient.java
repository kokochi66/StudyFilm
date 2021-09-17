package sample2.kokochi.hello.lifecycle;

public class NetworkClient {
    
    private String url;
    
    public NetworkClient() {
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
}
