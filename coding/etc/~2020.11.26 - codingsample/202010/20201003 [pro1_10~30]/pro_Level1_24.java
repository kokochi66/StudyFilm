public class pro_Level1_24 {
    public static int[] solution(long n) {
        int[] output = new int[(n+"").length()];
        int outputNum = 0;
        while(n>0){
            output[outputNum++] = (int)(n%10);
            n /= 10;
        }
        return output;
    }
}
