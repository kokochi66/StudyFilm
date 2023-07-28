
import java.util.*;

public class pro_Level2_13 {
    public static HashSet<Integer> Prime = new HashSet<Integer>();

    public static boolean isPrime(StringBuilder s){
        int a = Integer.parseInt(s.toString());
        if(a<=1 || Prime.contains(a)) return false;
        for(int i=2;i<=(int)Math.sqrt(a);i++){
            if(a%i==0) return false;
        }
        // System.out.println(a);
        Prime.add(a);
        return true;
    }
    public static int Func1(StringBuilder s, StringBuilder TempNum, boolean[] visited, int CurrSwit, int sum){
        visited[CurrSwit] = true;
        TempNum.append(s.charAt(CurrSwit));
        // System.out.println(TempNum+" "+sum);
        if(isPrime(TempNum)) {
            sum++;
        }
        for(int i=0;i<s.length();i++){
            if(!visited[i]) {
                sum += Func1(s,TempNum,visited,i,0);
            }
        }
        visited[CurrSwit] = false;
        TempNum.deleteCharAt(TempNum.length()-1);
        return sum;
    }
    public static int solution(String numbers) {
        StringBuilder s = new StringBuilder(numbers);
        StringBuilder TempNum = new StringBuilder();
        boolean[] vis = new boolean[numbers.length()];
        Arrays.fill(vis, false);
        int answer = 0;
        for(int i=0;i<s.length();i++){
            Arrays.fill(vis, false);
            TempNum.delete(0, TempNum.length());
            answer+=Func1(s, TempNum, vis, i, 0);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("011"));
    }
}
