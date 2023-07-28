public class pro_Level1_17 {
    public static int solution(int n) {
        int sum = 1, tempsqr;
        for(int i=3;i<=n;i++){
            tempsqr = (int) Math.sqrt(i);
            for(int j=1;j<=tempsqr;j++){
                if(i%j==0 && j!=1) break;
                else if(j>=tempsqr) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}
