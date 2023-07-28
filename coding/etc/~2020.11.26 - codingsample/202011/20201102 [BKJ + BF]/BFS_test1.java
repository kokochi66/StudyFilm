import java.util.*;

public class BFS_test1 {
    // 트리구조-큐를 이용한 너비우선 탐색 예제

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};    
        // 1 > 2 > 3 > 4 > 5 > 6 > 7
        BFS(a);
    }
    public static void BFS(int[] arr){
        if(arr.length<=0) return;
        Queue<Integer> que = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int index = 0;
        que.add(index);
        while(!que.isEmpty()){
            int Curr = que.poll();
            System.out.print(arr[Curr]+" ");
            int next = (Curr*2)+1;
            if(next<arr.length) que.offer(next);
            if(next+1<arr.length) que.offer(next+1);
        }
    }

}
