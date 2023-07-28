public class pro_Level1_26 {
    public static long solution(long n) {
        if(Math.sqrt(n) == (long)Math.sqrt(n)){
            return (long)Math.pow(Math.sqrt(n)+1,2);
        }
        else return (long)-1;
    }
}
