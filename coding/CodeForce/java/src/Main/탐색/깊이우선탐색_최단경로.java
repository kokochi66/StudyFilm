package src.Main.탐색;

import java.util.Arrays;
import java.util.Stack;

public class 깊이우선탐색_최단경로 {
    public static boolean 깊이우선탐색_재귀(int[][] edge, boolean[] used,int ci, int target) {
        if(ci == target) return true;
        System.out.println(ci +" " + Arrays.toString(used));
        int n = edge.length;
        for(int i=0;i<n;i++) {
            if(edge[ci][i] == 1 && !used[i]) {
                used[i] = true;
                if(깊이우선탐색_재귀(edge,used,i,target)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static boolean 깊이우선탐색_스택(int[][] edge, boolean[] used,int ci, int target) {
        int n = edge.length;
        Stack<Integer> st = new Stack<Integer>();
        st.push(ci);
        used[ci] = true;
        while(!st.isEmpty()) {
            int c = st.pop();
            System.out.println(c +" " + Arrays.toString(used));
            if(c == target) return true;
            for(int i=0;i<n;i++) if(!used[i] && edge[c][i] == 1) {
                used[i] = true;
                st.push(i);
            }
        }
        return false;
    }



    static int[][] arr = {
            {0,1,1,1,0},
            {1,0,1,0,0},
            {1,1,0,0,1},
            {0,1,0,0,1},
            {0,1,0,0,0}
    };
    static boolean[] used;
    public static void main(String[] args) {
        used = new boolean[arr.length];
		System.out.println(깊이우선탐색_재귀(arr,used,0,4));
//        System.out.println(깊이우선탐색_스택(arr,used,0,4));
    }
}
