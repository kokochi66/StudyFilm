import java.util.*;
import java.util.stream.Stream;
// https://codechacha.com/ko/java8-stream-concat/ 에서의 실습내용을 보고 공부하였음.
public class Ex_chStream_Test4 {
    public static void main(String[] args){
        List<String> li = Arrays.asList("a","b","c");
        List<String> li_2 = Arrays.asList("1","2","3");
        System.out.println("Stream 1 ::");
        Stream.concat(li.stream(), li_2.stream()).forEach(System.out::println);
        System.out.println("==========================");

        List<String> li2_1 = Arrays.asList("zcbfdg","asd","sdrqrazsfsfdgh","gxcvzt");
        List<Integer> li2_2 = Arrays.asList(4,1233,42,235,64);
        System.out.println("Stream 2_1 ::");
        li2_1.stream().sorted().forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Stream 2_2 ::");
        li2_2.stream().sorted().forEach(System.out::println);
        System.out.println("==========================");
        //일반적인 크기에 따른 정렬

        System.out.println("Stream 3 ::");
        li2_1.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        li2_1.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        System.out.println("==========================");
        //길이에 따른 정렬과 뒤집기

    }
    
}
