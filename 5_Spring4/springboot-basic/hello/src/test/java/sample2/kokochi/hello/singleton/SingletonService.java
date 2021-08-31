package sample2.kokochi.hello.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해서 new 키워드를 사용한 객체 생성을 하지 못하도록 막는다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
