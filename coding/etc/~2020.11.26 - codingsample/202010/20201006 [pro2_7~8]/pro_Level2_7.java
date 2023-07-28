import java.util.*;
public class pro_Level2_7 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck = new LinkedList<Integer>();
        Queue<Integer> WeightBridge = new LinkedList<Integer>();
        LinkedList<Integer> InBridge = new LinkedList<Integer>();
        for(int i=0;i<truck_weights.length;i++) truck.offer(truck_weights[i]);
        int time =0, CurrWeight = 0, ExTime = 0;
        while(!(truck.isEmpty() && InBridge.isEmpty())){
            if(!truck.isEmpty() && CurrWeight + truck.peek() <= weight){
                WeightBridge.add(truck.peek());
                CurrWeight += truck.peek();
                truck.poll();
                InBridge.add(0);
                time++;
                for(int i=0;i<InBridge.size();i++) InBridge.set(i,InBridge.get(i)+1);
            }
            else {
                System.out.println("IN EX");
                ExTime = bridge_length-InBridge.get(0);
                for(int i=0;i<InBridge.size();i++) InBridge.set(i,InBridge.get(i)+ExTime);
                time += ExTime;
            }
            if(InBridge.get(0)>=bridge_length) {
                CurrWeight -= WeightBridge.peek();
                WeightBridge.poll();
                InBridge.remove(0);
            }
            int[] test = new int[InBridge.size()];
            for(int i=0;i<InBridge.size();i++) test[i] = InBridge.get(i);
            System.out.println(Arrays.toString(test) + " Time = "+time);

        }
        return time+1;
    }
    public static void main(String[] args){
        int[] a = {2,2,2,2,2};
        int[] b = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(100,99,b));
    }
}
