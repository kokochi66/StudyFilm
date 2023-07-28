import java.util.Arrays;

public class StringTest {
    public static void main(String[] args){
        String a = new String("Hello, my name is kokochi kochi");
        // 1) String 클래스는 static 클래스로써, 정해진 문자열을 변경하는것은 불가능하다.

        int var1 = 25;
        String b = String.format("var1의 수는 = %d", var1);
        System.out.println("format : " + b);
        // 2) format을 이용해서 scanf형식으로 문자열을 입력해줄 수 있다.

        b = a.toUpperCase();
        System.out.println("equals : " +  a.equals("Hello, my name is korchi"));
        System.out.println("equalsIgnoreCase : " +  a.equalsIgnoreCase(b));
        // 3) equals를 이용해서 문자열간의 비교가 가능하다( == 으로는 안됨 )
        // 3.1) equalsIgnoreCase는 대소문자를 구분하지 않고 비교

        System.out.println("split : " +   Arrays.toString(a.split(" ")));
        // 4) split을 이용해서 문자열을 특정 문자를 기준으로 나누는 것이 가능하다.

        a = " oh oh good   ";
        System.out.println("trims : " +  a.trim());
        // 5) trim을 이용하여 문자열 앞뒤에 남아있는 공백을 제거한다.

        a = "aaqaqqaqaqqa";
        System.out.println("replace : " +  a.replace('a','b'));
        // 6) replace를 이용하여 문자열 내의 특정 문자를 다른값으로 변경할 수 있다.

        System.out.println("charAt : " +  a.charAt(0));
        // 7) charAt을 이용해서 문자열의 특정 값을 꺼내올 수 있다.

        System.out.println("substring : " +  a.substring(2,5));
        // 8) substring을 이용해서 문자열의 특정 위치 [2,5) 까지의 문자열을 분리하여 추출한다.

        a = "ABcDEf";
        System.out.println("toLowerCase : " +  a.toLowerCase());
        System.out.println("toUpperCase : " +  a.toUpperCase());
        // 9) toLowerCase를 이용해서 문자열의 모든 알파벳을 소문자로 만든다. 반대로 UpperCase는 대문자로 만든다.

        a = "super";
        b = "star";
        System.out.println("compareTo : " +  a.compareTo(b));
        // 10) compareTo를 이용해서 a가 b보다 사전적으로 먼저나오는지, 뒤에 나오는지를 비교한다.

        System.out.println("concat : " +  a.concat(b));
        // 11) concat을 통해 문자열 뒤에 새로운 문자를 붙일 수 있다.

        System.out.println("contains : " +  a.contains(b));
        // 12) contains를 이용해서 a안에 b를 포함하고 있는지를 확인할 수 있다.




    }
}