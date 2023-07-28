import java.util.*;
import java.io.*;

public class CONT_1117 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static char[][] dcarr;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    static Queue<Integer[]> queue;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            h = Integer.parseInt(tok.nextToken());
            w = Integer.parseInt(tok.nextToken());
            dcarr = new char[h][w];
            for(int i=0;i<h;i++){
                dcarr[i] = Read.readLine().toCharArray();
            }
            int count  = 0;
            queue = new LinkedList<Integer[]>();
            for(int i=0;i<h-1;i++){
                for(int j=0;j<w-1;j++){
                    int oc = 0 ;
                    if(i<h-1&&j<w-1){
                        for(int k=i;k<i+2;k++){
                            for(int z=j;z<j+2;z++){
                                if(dcarr[k][z]=='1') oc++;
                            }
                        }
                    }
                    if(oc == 4){
                        CONT_1117_3_dfs(i,j, 1);
                        count++;
                    } else if(oc == 3){
                        CONT_1117_3_dfs(i,j, 2);
                        count++;
                    } else if(oc == 2){
                        CONT_1117_3_dfs(i,j,3);
                        count+=2;
                    }
                    else if(oc == 1){
                        CONT_1117_3_dfs(i,j, 0);
                        count+=3;
                    }
                }
                // for(int t1=0;t1<h;t1++) System.out.println(Arrays.toString(dcarr[t1]));
            }
            Write.write(count+"");
            Write.newLine();
            while(!queue.isEmpty()){
                Integer[] c = queue.poll();
                for(int i=0;i<c.length;i++) Write.write(c[i]+" ");
                Write.newLine();
            }
            Write.write(count+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1117_3_dfs(int hi, int wi, int dir) throws Exception{
        if(dir==0) {
            if(dcarr[hi][wi]=='1'){
                dcarr[hi][wi] = '0';
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
            } else if(dcarr[hi][wi+1]=='1'){
                dcarr[hi][wi+1] = '0';
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
                queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+2),(hi+2),(wi+1)});
            } else if(dcarr[hi+1][wi]=='1'){
                dcarr[hi+1][wi] = '0';
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
                queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+2),(hi+2),(wi+1)});
            } else if(dcarr[hi+1][wi+1]=='1'){
                dcarr[hi+1][wi+1] = '0';
                queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+2),(hi+2),(wi+1)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
            }
        }
        else if(dir==1){
            dcarr[hi][wi] = '0';
            dcarr[hi+1][wi] = '0';
            dcarr[hi][wi+1] = '0';
            queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+1),(wi+2)});
        }
        else if(dir==2){
            if(dcarr[hi][wi]=='0') {
                queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+1),(hi+2),(wi+2)});
            } else if(dcarr[hi+1][wi]=='0') {
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
            } else if(dcarr[hi][wi+1]=='0') {
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
            } else if(dcarr[hi+1][wi+1]=='0') {
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+1),(wi+2)});
            }
            dcarr[hi][wi] = '0';
            dcarr[hi][wi+1] = '0';
            dcarr[hi+1][wi] = '0';
            dcarr[hi+1][wi+1] = '0';
        }
        else if(dir==3){
            if(dcarr[hi][wi]=='1'){
                if(dcarr[hi][wi+1]=='1') {
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
                    queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+2),(hi+2),(wi+1)});
                }
                else if(dcarr[hi+1][wi]=='1') {
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
                    queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+1),(hi+2),(wi+2)});
                }
                else if(dcarr[hi+1][wi+1]=='1'){
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                    queue.offer(new Integer[]{(hi+1),(wi+2),(hi+2),(wi+1),(hi+2),(wi+2)});
                }
            } else if(dcarr[hi][wi+1]=='1'){
                if(dcarr[hi+1][wi+1]=='1') {
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
                }else if(dcarr[hi+1][wi]=='1') {
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
                    queue.offer(new Integer[]{(hi+1),(wi+1),(hi+2),(wi+1),(hi+2),(wi+2)});
                }
            } else {
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+1)});
                queue.offer(new Integer[]{(hi+1),(wi+1),(hi+1),(wi+2),(hi+2),(wi+2)});
            }
            dcarr[hi][wi] = '0';
            dcarr[hi][wi+1] = '0';
            dcarr[hi+1][wi] = '0';
            dcarr[hi+1][wi+1] = '0';
        }
    }
    public static void CONT_1117_2() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());
            m = Integer.parseInt(tok.nextToken());
            tok = new StringTokenizer(Read.readLine());
            arr = new int[n*m];
            for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(tok.nextToken());
            // 입력부 O
            int tonn = (n/2)+1;
            int index = arr.length;
            long sum = 0;
            for(int i=0;i<m;i++){
                index -= tonn;
                sum += arr[index];
            }
            Write.write(sum+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1117_1() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        int[] c = new int[2];
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());
            c[0] = Integer.parseInt(tok.nextToken());
            c[1] = Integer.parseInt(tok.nextToken());
            h = Integer.parseInt(tok.nextToken());
            StringBuilder str = new StringBuilder(Read.readLine());
            int[] nc = new int[2];
            // 입력부 O
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0') nc[0]++;
                else nc[1]++;
            }

            int xcoin = Math.max(c[0], c[1]);
            int ncoin = Math.min(c[0],c[1]);
            if(h+ncoin >= xcoin) {
                int res = (c[0]*nc[0]) + (c[1]*nc[1]);
                Write.write(res+"");
            } else {
                int res = 0;
                if(ncoin == c[0]) {
                    res += (ncoin*nc[0]) + ((ncoin+h)*nc[1]);
                } else {
                    res += (ncoin*nc[1]) + ((ncoin+h)*nc[0]);
                }
                Write.write(res+"");
            }
            Write.newLine();
        }
        Write.flush();
    }
}