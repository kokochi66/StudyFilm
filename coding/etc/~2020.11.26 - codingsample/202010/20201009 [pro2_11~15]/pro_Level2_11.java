import java.util.stream.*;
public class pro_Level2_11 {
    public static String solution(String number, int k) {
        int max = 0;
        for(int i=0;i<=k;i++){
            if(number.charAt(i)-'0' == 9) {
                max = 9;
                break;
            }
            else if(max<number.charAt(i)-'0') max = number.charAt(i)-'0';
        }
        int index = number.indexOf(max+"");
        k -= index;
        StringBuilder answer = new StringBuilder(number.substring(index,number.length()));
        for(int i=0;i<answer.length()-1;i++){
            if(k>0 && (answer.charAt(i)-'0' == 0 || answer.charAt(i)-'0' < answer.charAt(i+1)-'0')){
                answer.delete(i, i+1);
                k--;
                i-=2;
            }
            else if(k==0) break;
        }
        if(k>0) answer = answer.delete(answer.length()-k,answer.length());
        return answer.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("4177252841",5));
    }
}
