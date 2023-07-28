import java.util.*;
import java.io.*;

public class PRO1120 {
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
        String[] a = {"N~F=0","R~T>2"};
        String[] a1 = {"A~C=0","F~J=0","M~N=0","R~T=0"};
        String[] a2 = {"A~C<7"};
        String[] a3 = {"N~F=5","R~F=0"};
        System.out.println(solution(a3.length,a3));
    }
    static HashMap<Character, Integer> ALKey;
    static ArrayList<ArrayList<Cons>> list; 
    static String[] sarr;
    static char[] carr;
    static char[] cper = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static int solution(int n, String[] data) {
        sarr = new String[n];
        for(int i=0;i<n;i++) sarr[i] = data[i];
        ALKey = new HashMap<Character, Integer>();
        ALKey.put('A',0);
        ALKey.put('C',1);
        ALKey.put('F',2);
        ALKey.put('J',3);
        ALKey.put('M',4);
        ALKey.put('N',5);
        ALKey.put('R',6);
        ALKey.put('T',7);
        // 0 1 2 3 4 5 6 7
        // A C F J M N R T
        list = new ArrayList<ArrayList<Cons>>();
        for(int i=0;i<8;i++) list.add(new ArrayList<Cons>());
        for(int i=0;i<n;i++){
            list.get(ALKey.get(data[i].charAt(0))).add(new Cons(ALKey.get(data[i].charAt(2))
                ,data[i].charAt(4)-'0',data[i].charAt(3)));
        }
        // 입력 O

        // for(int i=0;i<8;i++){
        //     System.out.println(i+"번째::::::::::::::::");
        //     for(int j=0;j<list.get(i).size();j++){
        //         Cons c = list.get(i).get(j);
        //         System.out.print(c.next+" "+c.con+" "+c.weight+"    ");
        //     }
        //     System.out.println();
        // }

        used = new boolean[8];
        oper = new int[8];
        s1_btk(0);
        return m;
    }
    public static void s1_btk(int k){
        if(k==8) {
            if(s1_check()) {
                m++;
                System.out.println(Arrays.toString(oper));
            }
        } else {
            for(int i=0;i<8;i++ ){
                if(!used[i]){
                    oper[k] = i;
                    used[i] = true;
                    s1_btk(k+1);
                    used[i] = false;
                }
            }
        }
    }
    public static boolean s1_check(){
        for(int i=0;i<sarr.length;i++){
            int fr=0, next=0, dist=0, wet = sarr[i].charAt(4)-'0';
            for(int j=0;j<8;j++){
                if(cper[oper[j]] == sarr[i].charAt(0)) fr=j;
                if(cper[oper[j]] == sarr[i].charAt(2)) next=j;
            }
            dist = Math.abs(fr-next)-1;
            if(sarr[i].charAt(3) == '=' && dist != wet){
                return false;
            } else if(sarr[i].charAt(3) == '<' && dist >= wet){
                return false;
            } else if(sarr[i].charAt(3) == '>' && dist <= wet){
                return false;
            }
        }
        return true; 
    }
    static class Cons {
        int next, weight;
        char con;
        public Cons(int n, int w, char c){
            this.next = n;
            this.weight = w;
            this.con = c;
        }
    }
}