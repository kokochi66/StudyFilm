import java.util.ArrayList;
import java.util.LinkedList;

public class pro3_TestHash {
    public static int solution(String[][] clothes) {
        LinkedList<String> cloth = new LinkedList<String>();
        ArrayList<Integer> HaveNum = new ArrayList<Integer>();
        for(int i=0;i<clothes.length;i++){
            if(cloth.contains(clothes[i][1])) {
                int j = 0;
                while(!cloth.get(j).equals(clothes[i][1])) j++;
                HaveNum.set(j, HaveNum.get(j)+1);
            }
            else {
                cloth.add(clothes[i][1]);
                HaveNum.add(1);
            }
        }
        int tempProduct = 1;
        for(int i=0;i<HaveNum.size();i++){
            tempProduct *= (HaveNum.get(i)+1);
        }
        return tempProduct-1;
    }
    public static void main(String[] args){
        String[][] input = {
            {"a","1"},
            {"b","1"},
            {"c","1"},
            {"d","2"},
            {"e","2"},
            {"f","3"},
            {"g","3"},
            {"h","3"},
            {"a","4"},
            {"b","4"},
            {"c","4"},
            {"d","5"},
            {"e","5"},
            {"f","6"},
            {"g","6"},
            {"h","6"},
            {"a","7"},
            {"b","7"},
            {"c","7"},
            {"d","8"},
            {"e","8"},
            {"f","9"},
            {"g","9"},
            {"h","9"},
            
        };
        System.out.println(solution(input));

    }
    
}
