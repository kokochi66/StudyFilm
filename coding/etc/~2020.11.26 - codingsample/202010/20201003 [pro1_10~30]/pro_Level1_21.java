public class pro_Level1_21 {
    public static int solution(int n) {
        int sum = 0, tempsqr = (int)Math.sqrt(n);
        for(int i=1;i<=tempsqr;i++) if(n%i==0) { 
            if(i == (n/i)) sum += i;
            else sum += i+(n/i);
        }
        return sum;
    }
    
}
