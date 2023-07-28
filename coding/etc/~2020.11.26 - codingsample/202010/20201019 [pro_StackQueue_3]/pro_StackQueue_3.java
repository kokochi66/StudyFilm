import java.util.*;
public class pro_StackQueue_3 {
    // https://programmers.co.kr/learn/courses/30/lessons/42583

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck = new LinkedList<Integer>();
        Queue<Integer> WeightBridge = new LinkedList<Integer>();
        LinkedList<Integer> InBridge = new LinkedList<Integer>();

        // 1) 트럭 배열의 값들을 대기 트럭 큐인 truck에 넣어준다.
        for(int i=0;i<truck_weights.length;i++) truck.offer(truck_weights[i]);

        int time =0, CurrWeight = 0, ExTime = 0;
        // 총 걸린 시간인 time 초기화, 현재 다리에 들어가있는 무게를 잰다.
        // 여기서 트럭이 한번에 다리에 여러대가 들어갈 수 있으며, 또한 들어간 트럭이 나가면서 무게가 채워질 경우를 산정해서
        // 추가로 들어가는 시간인 ExTime을 함께 계산해준다.
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
        }
        // 최종값에는 마지막 트럭이 나가는 시간인 +1을 더해서 마무리한다.
        return time+1;
    }
    public static void main(String[] args){

    }
}
