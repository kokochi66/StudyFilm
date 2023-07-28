import java.math.BigInteger;

public class BigInteger_BigIntegerTest {
    public static void main(String[] args){
        BigInteger a = new BigInteger("123456789000");
        BigInteger b = new BigInteger("2");
        BigInteger c = new BigInteger("123456789002");
        System.out.println("더하기 = " + a.add(b));
        System.out.println("빼기 = " + a.subtract(b));
        System.out.println("곱하기 = " + a.multiply(b));
        System.out.println("나누기 = " + a.divide(b));
        System.out.println("나머지 = " + a.remainder(b));
        a = a.add(b); //a에 연산값을 적용하려면
        System.out.println("정수화 = " + a.intValue());
        System.out.println("Long화 = " + a.longValue());
        System.out.println("두 수의 비교[크면 1, 같으면 0, 작으면 -1] =" + a.compareTo(c));

    }
    
}
