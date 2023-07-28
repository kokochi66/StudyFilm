import java.util.*;
import java.io.*;

public class KNUcon_2 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {
        solution("00011011100000");
    }
    public static String solution(String src) {
        StringBuilder res = new StringBuilder();
        res.append(src.charAt(0));
        char Curr = res.charAt(0);
        int count = 0;
        for(int i=0;i<src.length();i++){
            if(Curr == src.charAt(i)){
                count++;
            } else {
                res.append((char)('A'+count-1));
                Curr = src.charAt(i);
                count = 1;
            }
            if(i==src.length()-1){
                res.append((char)('A'+count-1));
            }
        }
        return res.toString();
    }
    
}
