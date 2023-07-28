import java.util.*;
import java.io.*;
public class PRO1120_2 {
    static StringBuilder str;
    public static int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        str = new StringBuilder(s);
        str.deleteCharAt(0);
        str.deleteCharAt(str.length()-1);
        int n = 0;
        while(str.length()>0){
            int left=0;
            while(str.charAt(left)!='{') left++;
            int right = left+1;
            while(str.charAt(right)!='}') right++;
            StringTokenizer tok = new StringTokenizer(str.substring(left+1,right),",");
            str.delete(0, right+1);
            list.add(new ArrayList<Integer>());
            while(tok.hasMoreTokens()) {
                list.get(n).add(Integer.parseInt(tok.nextToken()));
            }
            n++;
        }
        // 입력부 O

        HashSet<Integer> set = new HashSet<>(); 
        int[] answer = new int[list.size()];
        for(int i=1;i<=list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(j).size() == i) {
                    for(int k=0;k<list.get(j).size();k++){
                        if(!set.contains(list.get(j).get(k)))  {
                            set.add(list.get(j).get(k));
                            answer[i-1] = list.get(j).get(k);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer)); 
        return answer;
    }

}
