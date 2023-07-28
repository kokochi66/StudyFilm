import java.io.*;
import java.util.*;

public class KNU_W9_1 {
    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tok;
    public static int[] arr;
    public static int[] oper;
    public static boolean[][] dused;
    public static int n, m, result, min, Count;
    public static int[] Queen;
    public static void main(String[] args) throws Exception {
        Solution();
    }

    public static void Solution() throws Exception {
        int input = Integer.parseInt(Read.readLine());
        m = input;
        Queen = new int[m];
        dused = new boolean[3][(input*2)-1];
        Func(0,0);

        Write.flush();
        Read.close();
        Write.close();
    }  
    public static void Func(int k, int ci) throws Exception {
        if(k==m){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(Queen[i] == j) Write.write("Q ");
                    else Write.write("* ");
                }
                Write.newLine();
            }
            Write.newLine();
        } else {
            for(int j=0;j<m;j++){
                if(!dused[0][j] && !dused[1][ci+j] && !dused[2][m+ci-j-1]) {
                    dused[0][j] = true;
                    dused[1][ci+j] = true;
                    dused[2][m+ci-j-1] = true;
                    Queen[ci] = j;

                    Func(k+1, ci+1);

                    dused[0][j] = false;
                    dused[1][ci+j] = false;
                    dused[2][m+ci-j-1] = false;
                }

            }
        }
    }
}
