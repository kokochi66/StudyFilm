import java.util.*;

public class pro_Level1_30 {
    public int[] solution(int a, int b) {
        ArrayList<Integer> bumA = new ArrayList<Integer>();
        ArrayList<Integer> bumB = new ArrayList<Integer>();
        for(int i=1;i<=(int)Math.max((int)Math.sqrt(a),(int)Math.sqrt(b));i++){
            if(i<=(int)Math.sqrt(a) && a%i==0) {
                bumA.add(i);
                bumA.add(a/i);
            }
            if(i<=(int)Math.sqrt(b) && b%i==0) {
                bumB.add(i); 
                bumB.add(b/i);
            }
        }
        int themax = 0;
        for(int i=0;i<bumA.size();i++){
            if(bumB.indexOf(bumA.get(i)) != -1 && bumA.get(i)>themax) themax = bumA.get(i);
        }
        int tempA = a, tempB = b;
        int ANum = 1, BNum = 1;
        while(tempA != tempB){
            if(tempA<tempB) tempA = a*ANum++;
            else if(tempA>tempB) tempB = b*BNum++;
        }
        int[] answer = new int[2];
        answer[0] = themax;
        answer[1] = tempA;
        return answer;
    }
}
