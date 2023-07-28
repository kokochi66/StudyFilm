import java.util.*;
import java.io.*;

public class CONT_1119 {
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
        Solution();
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        h = Integer.parseInt(tok.nextToken());
        darr = new int[m][2];
        arr = new int [n+5];
        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine());
            darr[i][0] =  Integer.parseInt(tok.nextToken());
            darr[i][1] =  Integer.parseInt(tok.nextToken());
        }
        // Insert O
        for(int i=0;i<m;i++){
            for(int j=darr[i][0];j<=darr[i][1];j++){
                arr[j]++;
            }
        }
        used = new boolean[n+1];
        int[] dyn = new int[n+1];
        for(int i=1;i<=h;i++) dyn[1] += arr[i];
        for(int i=2;i<=n-h;i++){
            dyn[i] = dyn[i-1]-arr[i-1]+arr[i+h-1];
        }
        System.out.println(Arrays.toString(dyn));

    }
    public static void CONT_1119_3() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            String str = Read.readLine();
            Stack<Character> sst = new Stack<>();
            Stack<Character> bst = new Stack<>();
            int count = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)== '(') {
                    sst.push('(');
                } else if(str.charAt(i)== ')') {
                    if(!sst.isEmpty()) {
                        count++;
                        sst.pop();
                    }
                } else if(str.charAt(i)== '[') {
                    bst.push('[');
                } else if(str.charAt(i)== ']') {
                    if(!bst.isEmpty()) {
                        count++;
                        bst.pop();
                    }
                }
            }
            Write.write(count+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1119_2() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            n = Integer.parseInt(Read.readLine());
            ArrayList<Integer> list  = new ArrayList<>();
            arr = new int[n];
            tok = new StringTokenizer(Read.readLine());
            used = new boolean[n];
            for(int i=0;i<n;i++) {
                list.add(Integer.parseInt(tok.nextToken()));
            }
            // Insert O
            Collections.sort(list);
            long max = list.get(list.size()-1);
            long sum = 0;
            for(int i=1;i<n-1;i++){
                sum += (max-list.get(i));
            }
            if(n==2) Write.write("0");
            // else if(list.get(0) == max) {
            //     if(max>=n-1) {
            //         if(max%(n-1) == 0)
            //         Write.write(((n-1)-(max%(n-1)))+"");
            //     }
            //     else Write.write(((n-1)-max)+"");   
            // }
            else {
                if(sum-list.get(0)>=0) Write.write((sum-list.get(0))+"");
                else {
                    long c = (list.get(0)-sum)%(n-1);
                    if(c==0) Write.write("0");
                    else Write.write(((n-1)-c)+"");
                }
            }
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1119_1() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());  
            m = Integer.parseInt(tok.nextToken());
            if(n==m) Write.write((n+m)+""); 
            else {
                int max = Math.max(n, m);
                Write.write(((max*2)-1)+"");
            }
            Write.newLine();
        }
        Write.flush();
    }
}