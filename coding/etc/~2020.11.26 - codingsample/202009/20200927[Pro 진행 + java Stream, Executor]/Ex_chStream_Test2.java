import java.util.*;
import java.util.stream.Stream;

// https://codechacha.com/ko/stream-filter/ 
// https://codechacha.com/ko/java8-stream-limit-skip/
//                                          에서의 실습내용을 보고 공부하였음.
public class Ex_chStream_Test2 {
    public static void main(String[] args){
        // 1) Filter => 스트림 내에서 특정값만을 추출해낸다.
        List<String> li1 = Arrays.asList("a","b","c");
        System.out.println("Stream 1 ::");
        li1.stream().filter(s->s.startsWith("c")).forEach(System.out::println);
        System.out.println("=========================");

        // 2) Map => 스트림 내에서 특정
        System.out.println("Stream 2 ::");
        li1.stream().map(s->s.toUpperCase()).forEach(System.out::println);
        System.out.println("=========================");

        // 3) FlatMap => 2차원 배열을 1차원 배열로 만들 수 있음.
        String[][] arr = new String[][]{{"a","b"},{"c","d"},{"e","f","g"},{"h"},{"i","j"}};
        System.out.println("Stream 3 ::");
        Arrays.stream(arr).flatMap(s->Arrays.stream(s)).forEach(System.out::println);
        System.out.println("=========================");

        // 4) Limit => 스트림의 내부에서 개수를 제한할 수 있음 (0~Limit)
        List<Integer> li4 = Arrays.asList(1,2,3,4,5);
        System.out.println("Stream 4 ::");
        li4.stream().limit(2).forEach(System.out::println);
        System.out.println("=========================");

        // 5) skip => 스트림 내부에서 개수를 제한할 수 있음 (skip~len)
        System.out.println("Stream 5 ::");
        li4.stream().skip(3).forEach(System.out::println);
        System.out.println("=========================");
    }
    
}
