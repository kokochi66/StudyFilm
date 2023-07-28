import java.util.*;
import java.util.stream.*;

public class pro_Level1_6 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] output = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] temp = IntStream.range(commands[i][0]-1, commands[i][1]).map(q->array[q]).toArray();
            Arrays.sort(temp);
            output[i] = temp[commands[i][2]-1];
            // System.out.println("정렬된 부분배열 = " + Arrays.toString(temp));
            // System.out.println("기본 array = " + Arrays.toString(array));
        }
        return output;
    }
    public static void main(String[] args){
        int[][] in = {{2,5,3},{4,4,1},{1,7,3}};
        int[] in2 = {1,5,2,6,3,7,4};
        System.out.println(Arrays.toString(solution(in2, in)));


    }
}
