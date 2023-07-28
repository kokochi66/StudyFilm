import java.util.*;

public class DFS_test1 {
    // 트리구조-스택을 이용한 너비우선 탐색 예제

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};    
        // 1 > 2 > 4 > 5 > 3 > 6 > 7
        DFS(a);
    }
    public static void DFS(int[] arr){
        if(arr.length<=0) return;
        Stack<Integer> stk = new Stack<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int index = 0;
        stk.push(index);
        System.out.print(arr[index]+" ");
        while(!stk.isEmpty()){
            index = stk.peek();
            int next = (index*2)+1;
            if(set.contains(next) || next>=arr.length) next++;
            if(set.contains(next) || next>=arr.length){
                stk.pop();
            } else {
                System.out.print(arr[next]+" ");
                stk.push(next);
                set.add(next);
            }
        }
    }
}
