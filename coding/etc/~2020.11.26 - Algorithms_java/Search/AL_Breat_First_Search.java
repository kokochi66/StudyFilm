
import java.util.*;

public class AL_Breat_First_Search {
    public static void main(String[] args){
        int[][] a = {
            {0,1,1,1,0,0,0,0,0,0,0},
            {1,0,0,0,1,1,0,0,0,0,0},
            {1,0,0,0,0,0,1,0,0,0,0},
            {1,0,0,0,0,0,0,1,1,0,0},
            {0,1,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,1,1},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
        };
        BFS(a,1);
    }

    public static void BFS(int[][] arr, int f) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[n];
        // 너비 우선탐색은 기본적으로 큐에 이미 지나간 값을 점검하는 used 불리언 배열을 통해 구현한다.

        q.offer(f);
        used[f] = true;
        System.out.println(f);
        // 큐에 첫번째 위치값 추가 및, used에 첫번째값 적용
        while(!q.isEmpty()){
            // while문을 통해 큐에 남은값이 없을때까지 반복한다.
            Integer c = q.poll();
            for(int i=0;i<n;i++){
                if(!used[i]&&arr[c][i]==1){
                    q.offer(i);
                    used[i] = true;
                    System.out.println(i);
                }
            }
            // 현재 위치에서 적용할 수 있는 모든 경우의 수를 큐에 적용 후 재탐색
        }
    }
    // 기본 적용할 수 있는 문제는 그래프 내에서 여러번의 조건부 확인이 필요한게 아닐때
    // 또한 중복되는 탐색방향이 없을때 가능하며, 경우의 수를 탐색하는 방법에는 비효율적임.
    // 시간복잡도 = Θ(n^2)
}
