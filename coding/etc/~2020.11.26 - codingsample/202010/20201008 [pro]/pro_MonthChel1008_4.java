import java.util.*;

public class pro_MonthChel1008_4 {

    public static long Maximum(String s){
        long x=0, y=s.length()-1;
        if(s.charAt((int)x) != s.charAt((int)y)) return y-x;
        while(s.charAt((int)x) == s.charAt((int)y)){
            x++;
            y--;
            // System.out.println(s+"  "+s.charAt((int)x)+"  "+s.charAt((int)y));
            if((s.charAt((int)x) != s.charAt((int)y+1))||(s.charAt((int)x-1) != s.charAt((int)y))) return y-x+1;
            if(x>=y) return 0;
        }
        return y-x;
    }
    public static long solution(String s) {
        if(s.length()==2) return Maximum(s);
        else if(s.length()==1) return 0;
        long sum=1, index = 3, subindex = 3;
        int[] alph = new int[26];
        Arrays.fill(alph, 0);
        LinkedList<Long> Pibb = new LinkedList<Long>();
        Pibb.add(sum);
        alph[s.charAt(s.length()-1)-'a']++;
        alph[s.charAt(0)-'a']++;
        for(long i=2;i<=s.length()-1;i++){
            alph[s.charAt((int)i-1)-'a']++;
            sum += (i*(i+1))/2;
            Pibb.add(sum);
        }
        for(int i=0;i<26;i++){
            if(alph[i]>=2) sum -= Pibb.get(alph[i]-2);
            System.out.println(sum + " " + alph[i]);
        }
        System.out.println(Pibb.get(4));
        return sum;
    }
    public static void main(String[] args){
        System.out.println(solution("aaabbcaaa"));
    }
}
