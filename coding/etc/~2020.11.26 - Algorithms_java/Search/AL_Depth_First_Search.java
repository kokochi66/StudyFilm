
import java.util.*;
public class AL_Depth_First_Search {
    static int n;
    static Stack<Integer> st;
    static boolean[] used;
    public static void init(int[][] arr) {
        n = arr.length;
        st= new Stack<>();
        used = new boolean[n];
    }
    public static void DFS(int[][] arr, int f) {
        used[f] = true;
        System.out.println(f);
        for(int i=0;i<n;i++){
            if(!used[i]&&arr[f][i]==1){
                DFS(arr,i);
            }
        }
        // 반복문을 돌면서 재귀호출을 통해 깊이를 탐색한다.
        // 시간복잡도 = Θ(n^2)
    }
}
