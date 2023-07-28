import java.util.*;

public class pro_hash_3 {
    // https://programmers.co.kr/learn/courses/30/lessons/42578

    public static int solution(String[][] clothes) {
        // 각 의상의 종류마다 의상의 개수를 map에 넣는다.
        HashMap<String, Integer> map = new HashMap<String, Integer>();  
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])) map.put(clothes[i][1] , map.get(clothes[i][1])+1);
            else map.put(clothes[i][1] , 1);
        }
        Iterator iter = map.keySet().iterator();
        int output = 1;
        while(iter.hasNext()) {
            // Map에서 값을 하나씩 빼면서 +1한 값을 곱해준다
            output *= (map.get(iter.next())+1);
        }
        return output-1;
        // 아무것도 안입는 경우의 수인 1개를 빼준 값을 출력한다.
    }
    public static void main(String[] args){

    }


}
