import java.util.*;

public class pro_Level1_34 {
    public static String solution(String phone_number) {
        char[] b = phone_number.toCharArray();
        Arrays.fill(b,0,phone_number.length()-4,'*');
        phone_number = new String(b);
        return phone_number;
    }
}
