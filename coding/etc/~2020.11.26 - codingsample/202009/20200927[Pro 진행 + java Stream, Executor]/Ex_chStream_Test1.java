import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;
// https://codechacha.com/ko/stream-creation/ 에서의 실습내용을 보고 공부하였음.
public class Ex_chStream_Test1 {
    public static void main(String[] args){
        //스트림 기초1 스트림 생성 -> 출력
        Stream<String> s1 = Stream.of("a","b","c");
        System.out.println("Stream 1 :: ");
        s1.forEach(s -> System.out.println(s));
        System.out.println("=======================");

        //스트림 기초2 널 스트림 생성 -> 출력
        Stream<String> s2 = Stream.empty();
        System.out.println("Stream 2 :: ");
        s2.forEach(s -> System.out.println(s));
        System.out.println("=======================");

        //스트림 기초3 스트림에 반복값 적용(리미트로 반복제한)
        Stream<String> s3 = Stream.generate(() -> "kokochi").limit(3);    
        System.out.println("Stream 3 :: ");
        s3.forEach(s -> System.out.println(s));
        System.out.println("=======================");

        //스트림 기초4 iterate를 이용한 반복값 적용(리미트로 반복제한)
        Stream<Integer> s4 = Stream.iterate(0, n -> n+3).limit(3);
        System.out.println("Stream 4 :: ");
        s4.forEach(System.out::println);
        System.out.println("=======================");

        //스트림 기초5 List를 스트림값으로 변경
        List<String> li = Arrays.asList("a","b","c");
        Stream<String> s5 = li.stream();
        System.out.println("Stream 5 :: ");
        s5.forEach(System.out::println);
        System.out.println("=======================");

        //스트림 기초6 Array를 스트림값으로 변경
        String[] arr = {"a","b","c"};
        Stream<String> s6 = Arrays.stream(arr);
        System.out.println("Stream 6 :: ");
        s6.forEach(System.out::println);
        System.out.println("=======================");

    }
    
}
