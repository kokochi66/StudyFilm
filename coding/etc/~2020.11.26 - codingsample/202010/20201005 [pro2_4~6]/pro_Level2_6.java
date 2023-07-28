import java.util.*;

public class pro_Level2_6 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progeresQ = new LinkedList<Integer>();
        for(int i=0;i<progresses.length;i++) progeresQ.add(progresses[i]);
        int FrontSpeed = 0;
        int day = 1;
        ArrayList<Integer> output = new ArrayList<Integer>();
        while(!progeresQ.isEmpty()){
            int count = 0;
            while(!progeresQ.isEmpty() && progeresQ.peek() + (speeds[FrontSpeed]*day) >= 100) {
                System.out.println(day);
                progeresQ.poll();
                count++;
                FrontSpeed++;
            }
            if(count>0) output.add(count);
            day++;
        }
        int[] outputArr = new int[output.size()];
        for(int i=0;i<output.size();i++) outputArr[i] = output.get(i);
        return outputArr;
    }
    public static void main(String[] args){
        int[] a = {93, 30, 55};
        int[] b = {10, 70, 50};
        System.out.println(Arrays.toString(solution(a, b)));
    }
    
}
