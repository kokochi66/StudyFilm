public class pro_Level1_33 {
    public static boolean solution(int x) {
        int digit = 0, tempX = x;
        while(tempX != 0){
            digit += tempX%10;
            tempX /= 10;
        }
        return x%digit==0;
    }
}
