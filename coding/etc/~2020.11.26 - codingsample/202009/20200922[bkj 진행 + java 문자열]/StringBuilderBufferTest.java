public class StringBuilderBufferTest {
    public static void main(String[] args){
        StringBuffer buff = new StringBuffer("Hey, what is your name?");
        StringBuilder buil = new StringBuilder("my name is");
        //둘다 사용법은 같으나, 빌더가 빠르고 덜안전, 버퍼가 느리고 안전

        System.out.println("append : " + buil.append(" kokorchi"));
        // 1) append를 이용해서 문자열 뒤에 새로운 문자열 추가 가능

        System.out.println("capacity : " + buil.capacity());
        System.out.println("length : " + buil.length());
        // 2) capacity를 이용해서 현재 스트링 버퍼의 크기를 출력함, 단순 문자열의 길이는 length (버퍼 크기는 자동으로 늘어남)

        System.out.println("delete : " + buil.delete(0, 3));
        // 3) delete를 이용해서 문자열 중간값을 제거가능. [0,3) 범위로 적용됨

        System.out.println("insert : " + buil.insert(8, "superPower "));
        // 4) insert를 이용해서 문자열 중간에 새로운값을 삽입가능.

        System.out.println("reverse : " + buil.reverse());
        // 5) reverse를 이용해서 문자열 뒤집기 가능

        System.out.println(buil.replace(0, 1, "a"));

        StringBuilder a = new StringBuilder("abcdef");
        System.out.println(a.delete(0, 1));

    }
}
