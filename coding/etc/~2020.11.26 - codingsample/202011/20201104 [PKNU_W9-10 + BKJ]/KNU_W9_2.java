import java.io.*;
import java.util.*;

public class KNU_W9_2 {

    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tok;
    public static int[] arr;
    public static int[] oper;
    public static boolean[] used;
    public static int n, m;
    public static boolean Check, OVER;
    public static StringBuilder output;
    public static StringBuilder input;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            input = new StringBuilder(sc.nextLine());
            arr = new int[input.length()];
            oper = new int[input.length()];
            used = new boolean[input.length()];
            output = new StringBuilder("");
            for(int i=0;i<input.length();i++) {
                if(input.charAt(i)=='0') arr[i] = 0;
                else arr[i] = 1;
            }
            OVER = false;
            n = input.length();
            m = input.length();

            Func(0);
            if(OVER) System.out.println("multiple");
            else if(output.toString().isEmpty()) System.out.println("zero");
            else System.out.println(output);
        }
    }

    public static void Func(int k) {
        // System.out.println(Arrays.toString(oper)+"  "+k);
        // System.out.println(Arrays.toString(used)+"  이번값");
        if(!OVER && k == m){
            StringBuilder temp = new StringBuilder("");
            for(int q=0;q<m;q++){
                int left = q-1>=0 ? q-1 : m-1, right = q+1==m ? 0 : q+1;
                if(oper[left] != oper[right]) temp.append((oper[q]==0?1:0)+"");
                else temp.append(oper[q]+"");
            }
            // System.out.println(temp);
            if(temp.toString().equals(input.toString())){
                if(!output.toString().isEmpty()) {
                    OVER = true;
                    return;
                }
                else {
                for(int i=0;i<m;i++) {
                    if(oper[i] == 0) output.append("0");
                    else output.append("1");
                    }
                }
            }
        } else if(!OVER && k<m) {
            int left = k-1>=0 ? k-1 : m-1, right = k+1==m ? 0 : k+1;
            used[k] = true;
            oper[k] = 0;
            Func(k+1);

            oper[k] = 1;
            Func(k+1);
            used[k] = false;

            // if(!used[left] && !used[right]){
            //     used[k] = true;
            //     oper[k] = 0;
            //     Func(k+1);

            //     oper[k] = 1;
            //     Func(k+1);

            //     used[k] = false;
            // } else if(!used[left] && used[right]){
            //     int rr = right+1>=m ? 0 : right+1;
            //     boolean rightEQ =  oper[right] == arr[right];
            //     boolean rrEQ = oper[rr] == arr[rr];
            //     if(!used[rr]){
            //         used[k] = true;
            //         oper[k] = 0;
            //         Func(k+1);

            //         oper[k] = 1;
            //         Func(k+1);

            //         used[k] = false;
            //     } else if(rightEQ) { 
            //         used[k] = true;
            //         oper[k] = oper[rr];
            //         Func(k+1);
            //         used[k] = false;
            //     } else if(!rightEQ) {
            //         used[k] = true;
            //         oper[k] = oper[rr]==0 ? 1 : 0;
            //         Func(k+1);
            //         used[k] = false;
            //     }
            // } else if(used[left] && !used[right]){
            //     int ll = left-1>=0 ? left-1 : m-1;
            //     boolean leftEQ =  oper[left] == arr[left];
            //     boolean llEQ = oper[ll] == arr[ll];
            //     if(!used[ll]){
            //         used[k] = true;
            //         oper[k] = 0;
            //         Func(k+1);

            //         oper[k] = 1;
            //         Func(k+1);

            //         used[k] = false;
            //     } else if(leftEQ) { 
            //         used[k] = true;
            //         oper[k] = oper[ll];
            //         Func(k+1);
            //         used[k] = false;
            //     } else if(!leftEQ) {
            //         used[k] = true;
            //         oper[k] = oper[ll]==0 ? 1 : 0;
            //         Func(k+1);
            //         used[k] = false;
            //     }
            // } else if(used[left] && used[right]) {
            //     int ll = left-1>=0 ? left-1 : m-1;
            //     boolean leftEQ =  oper[left] == arr[left];
            //     boolean llEQ = oper[ll] == arr[ll];
            //     int rr = right+1>=m ? 0 : right+1;
            //     boolean rightEQ =  oper[right] == arr[right];
            //     boolean rrEQ = oper[rr] == arr[rr];

            //     int swL, swR;
            //     if(leftEQ) swL = oper[ll];
            //     else swL = oper[ll]==0 ? 1 : 0;
            //     if(rightEQ) swR = oper[rr];
            //     else swR = oper[rr]==0 ? 1 : 0;
            //     if(swL==swR && swL == arr[k]) {
            //         used[k] = true;
            //         oper[k] = swL;
            //         Func(k+1);
            //         used[k] = false;
            //     } else return;
            // }
        }
    }
}
