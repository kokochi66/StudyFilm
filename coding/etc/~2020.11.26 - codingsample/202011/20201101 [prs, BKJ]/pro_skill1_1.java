import java.util.*;

public class pro_skill1_1 {

    public int[] solution1(int []arr) {
        Stack<Integer> stk = new Stack<Integer>();

        for(int i=0;i<arr.length;i++){
            if(!stk.isEmpty() && stk.peek() != arr[i]) {
                stk.push(arr[i]);
            } else if(stk.isEmpty())stk.push(arr[i]);
        }


        int[] output = new int[stk.size()];
        for(int i=output.length-1;i>=0;i--){
            output[i] = stk.pop();
        }
        return output;
    }

    public int solution2(int[] d, int budget) {
        
        int temp, output=0, sum=0;
        for(int i=1;i<d.length;i++){
            int j=i;
            while(j>0 && d[j]<d[j-1]){
                temp = d[j];
                d[j] = d[j-1];
                d[j-1] = temp;
                j--;
            }
        }
        int index = 0;
        while(index < d.length && sum<budget){
            sum += d[index++];
            output++;
            if(sum>budget){
                output--;
                break;
            }
        }
        return output;
    }

    public static void main(String[] args){

    }
}