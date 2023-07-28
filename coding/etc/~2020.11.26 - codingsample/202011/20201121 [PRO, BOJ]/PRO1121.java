import java.util.*;
public class PRO1121 {
    public int solution(int n) {
        int res = n+1;
        int count = 0;
        int index = 1;
        while(index < n){
            if((n&index)!=0) count++;
            index<<=1;
        }
        while(true){
            index = 1;
            int resc = 0;
            while(index < res){
                if((res&index)!=0) resc++;
                index<<=1;
            }
            if(resc==count) return res;
            res++;
        }
    }

    boolean solution2(String s) {
        Stack<Character> st = new Stack<>();
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') st.push('(');
            else if(st.isEmpty()) return false;
            else st.pop();
        }
        return st.isEmpty();
    }
}
