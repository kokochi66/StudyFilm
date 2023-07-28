public class pro_Level1_19 {
    public static int solution(String s) {
        int temp = 1;
        if(s.charAt(0) == '+') s = s.substring(1,s.length());
        else if(s.charAt(0) == '-') {
            temp = -1;
            s = s.substring(1,s.length());
        }
        return Integer.parseInt(s) * temp;
    }
}
