import java.util.ArrayList;
import java.util.Arrays;

public class pro_Level1_9 {
    public static int[] solution(int[] arr) {
        int temp = -1;
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != temp) {
                temp = arr[i];
                output.add(temp);
            }
        }
        int[] outputTemp = new int[output.size()];
        for(int i=0;i<output.size();i++) outputTemp[i] = output.get(i);
        return outputTemp;
    }
    public static void main(String[] args){
        int[] input = {1,1,1,2,2,3,3,3,3,3,3,0,0,1};
        System.out.println(Arrays.toString(solution(input)));

    }
    
}
