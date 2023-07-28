public class pro_Level1_36 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(long i=1;i<=n;i++){
            answer[(int)(i-1)] = x*i;
        }
        return answer;
    }
}
