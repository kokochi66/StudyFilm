import java.util.*;
public class PRO1124 {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int res1=0, res2=0;
        char last = ' ';
        for(int i=1;i<=words.length;i++){
            if(!set.contains(words[i-1]) && (last==' ' || last == words[i-1].charAt(0))) {
                set.add(words[i-1]);
                last = words[i-1].charAt(words[i-1].length()-1);
            }
            else {
                res1 = i%n==0 ? n : i%n;
                res2 = (i/n)+1;
                break;
            }
        }
        return new int[]{res1,res2};
    }
}
