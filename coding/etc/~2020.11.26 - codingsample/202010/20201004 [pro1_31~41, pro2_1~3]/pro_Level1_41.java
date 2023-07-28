import java.util.*;
import java.util.stream.*;

public class pro_Level1_41 {
    public static int solution(String dartResult) {
        char[] tempCharArr = dartResult.toCharArray();
        ArrayList<Integer> ScoreList = new ArrayList<Integer>();
        int i = 0 ,CurrSwit = 0;
        while(i < tempCharArr.length){
            if(tempCharArr[i] >= '0' && tempCharArr[i] <= '9'){
                if(tempCharArr[i] == '1'){
                    if((i+1)!=tempCharArr.length && tempCharArr[i+1] == '0'){
                        ScoreList.add(10);
                        i++;
                    }
                    else ScoreList.add(1);
                }
                else ScoreList.add(tempCharArr[i] - '0');
                CurrSwit++;
            }
            else if(tempCharArr[i] == 'D') ScoreList.set(CurrSwit-1, (int)Math.pow(ScoreList.get(CurrSwit-1),2));
            else if(tempCharArr[i] == 'T') ScoreList.set(CurrSwit-1, (int)Math.pow(ScoreList.get(CurrSwit-1),3));
            else if(tempCharArr[i] == '*') {
                if(CurrSwit>1) ScoreList.set(CurrSwit-2, ScoreList.get(CurrSwit-2)*2);
                ScoreList.set(CurrSwit-1, ScoreList.get(CurrSwit-1)*2);
            }
            else if(tempCharArr[i] == '#') {
                ScoreList.set(CurrSwit-1, ScoreList.get(CurrSwit-1)*(-1));
            }
            i++;
        }
        return IntStream.range(0, ScoreList.size()).map(q->ScoreList.get(q)).sum();
    }
}
