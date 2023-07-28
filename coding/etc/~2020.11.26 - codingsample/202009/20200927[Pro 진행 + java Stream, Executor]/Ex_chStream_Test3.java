import java.util.*;
import java.util.stream.Stream;

// https://codechacha.com/ko/java8-stream-distinct/ 에서의 실습내용을 보고 공부하였음.
public class Ex_chStream_Test3 {
    public static void main(String[] args){
        // distinct -> 스트림 내부의 중복을 제거하는 함수 (집합과 같이 사용할 수 있을듯함.)
        List<String> li = Arrays.asList("a","a","a","b","b","c","c","c");
        System.out.println("Stream 1 ::");
        li.stream().distinct().forEach(System.out::println);
        System.out.println("======================");
        
        List<Integer> li2 = Arrays.asList(1,1,2,2,3);
        System.out.println("Stream 2 ::");
        li2.stream().distinct().forEach(System.out::println);
        System.out.println("======================");
        // 기본 자료형의 경우에는 자체적으로 비교함수가 적용되어서 적용이 가능함. 하지만 다른경우에는 직접 적용해주여야함.
        P1();
    }

    public static class kokochi {
        public String str;
        public kokochi(String str){
            this.str = str;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof kokochi) return str.equals(((kokochi)o).str);
            else return false;
        }
        @Override
        public int hashCode(){
            return str.hashCode();
        }
        @Override
        public String toString(){
            return str;
        }
    }
    public static void P1() {
        System.out.println("Stream 4 ::");
        List<kokochi> li = Arrays.asList(new kokochi("a"),new kokochi("a"),new kokochi("b"),new kokochi("b"));
        li.stream().distinct().forEach(System.out::println);
        System.out.println("======================");

    }
}
