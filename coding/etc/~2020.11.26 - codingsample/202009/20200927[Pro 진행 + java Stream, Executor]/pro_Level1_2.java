import java.util.*;

public class pro_Level1_2 {
    //27일날 올리는거 깜빡해서 28일날 올림
    public static int[] solution(int[] numbers) {
        HashSet<Integer> term = new HashSet<Integer>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                term.add(numbers[i]+numbers[j]);
            }
        }
        Iterator it = term.iterator();
        int[] output = new int[term.size()];
        int otNum = 0;
        while(it.hasNext()) output[otNum++] = (int) it.next();
        Arrays.sort(output);
        return output;
    }
    public static void main(String[] args){
        int[] a = {2,1,3,1,4};
        System.out.println(Arrays.toString(solution(a)));
    }
    
}
