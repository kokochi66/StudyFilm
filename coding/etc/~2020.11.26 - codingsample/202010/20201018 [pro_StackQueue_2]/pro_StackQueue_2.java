import java.util.*;

public class pro_StackQueue_2 {
    // https://programmers.co.kr/learn/courses/30/lessons/42586
    // 전형적인 큐의 성질을 이용 한 줄서기식 프로그램.
    public static int[] solution(int[] progresses, int[] speeds) {
        // 1) progresses의 모든 값을 speed와 함께 큐에 넣어준다 (순서가 중요하기 때문에 일단 큐에 넣는다.)
        // 2) 맨 앞의 순서값이 100이 될때까지 기다려야 하기 때문에 i*speed값에 progresses를 더한값이 100이 될때까지 기다린다.
        // 3) 해당값이 100 이상이라면 뒤의값도 계속 반환한다.
        // 4) 여기서 최댓값을 알기 어려우므로 리스트로 구현 후에 배열로 변경해주는 과정을 거친다.
        Queue<Integer[]> koko = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            koko.add(new Integer[]{progresses[i],speeds[i]});
        }
        
        ArrayList<Integer> outputList = new ArrayList<>();
        int j = 1;
        while(!koko.isEmpty()){
            int counter = 0;
            int Curr = koko.peek()[0] + (koko.peek()[1]*j);
            while(Curr >= 100) {
                counter++;
                koko.poll();
                Curr = 0;
                if(!koko.isEmpty()) Curr = koko.peek()[0] + (koko.peek()[1]*j);
            }
            if(counter>0) outputList.add(counter);
            j++;
        }
        int[] output = new int[outputList.size()];
        for(int i=0;i<output.length;i++) output[i] = outputList.get(i);
        return output;
    }
    public static void main(String[] args){

    }
}
