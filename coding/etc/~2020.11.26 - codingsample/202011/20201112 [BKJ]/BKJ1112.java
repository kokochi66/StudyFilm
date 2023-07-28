import java.util.*;
import java.io.*;

public class BKJ1112 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static char[] carr;
    static char[][] dcarr, dcper;
    static boolean[] used, check;
    static boolean[][][] tused;
    static int h, w, n, m, count, min, max;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void BKJ1112_14() throws Exception {
        n = Integer.parseInt(Read.readLine());
        int x = 64;
        int res = 64;
        int count = 1;
        while(res != n){
            if(n < res) {
                while(x>n) x/=2;
                res = x;
                count = 1;
            } else if(n>res){
                while(x+res > n) x/=2;
                count++;
                res += x;
            }
        }
        System.out.println(count);
    }
    public static void BKJ1112_13() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        System.out.println((m*2)-n);
    }
    public static void BKJ1112_12() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        long[] arr = new long[5];
        long sum = 0;
        for(int i=0;i<5;i++) {
            arr[i] = Long.parseLong(tok.nextToken());
            arr[i] *= arr[i];
            sum += arr[i];
        }
        System.out.println(sum%10);
    }
    public static void BKJ1112_11() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        arr = new int[n+5];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1]*i;
        }
        System.out.println(arr[n]/(arr[n-m]*arr[m]));
    }
    public static void BKJ1112_9_10() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        arr = new int[m];
        BKJ1112_10_btk(0,1);
        Write.flush();
    }
    public static void BKJ1112_10_btk(int k, int ci) throws Exception {
        if(k==m){
            for(int i=0;i<m;i++){
                Write.write(arr[i]+" ");
            }
            Write.newLine();
        } else {
            for(int i=ci;i<=n;i++){
                arr[k] = i;
                BKJ1112_10_btk(k+1, i);
            }
        }
    }
    public static void BKJ1112_9_btk(int k) throws Exception {
        if(k==m){
            for(int i=0;i<m;i++){
                Write.write(arr[i]+" ");
            }
            Write.newLine();
        } else {
            for(int i=1;i<=n;i++){
                arr[k] = i;
                BKJ1112_9_btk(k+1);
            }
        }
    }
    public static void BKJ1112_8() throws Exception {
        int m = Integer.parseInt(Read.readLine());
        arr = new int[m];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        tok = new StringTokenizer(Read.readLine());
        int b = Integer.parseInt(tok.nextToken());
        int c = Integer.parseInt(tok.nextToken());
        long count = 0;
        for(int i=0;i<m;i++){
            count++;
            arr[i] -= b;
            if(arr[i]<0) arr[i] = 0;
            count += (long)(arr[i]/c);
            if(arr[i]%c!=0 && arr[i]!=0) count++;
        }
        Write.write(count+"");
        Write.flush();
    }
    public static void BKJ1112_7() throws Exception {
        int res = 0, max = 0;
        for(int i=0;i<4;i++){
            tok = new StringTokenizer(Read.readLine());
            res -= Integer.parseInt(tok.nextToken());
            res += Integer.parseInt(tok.nextToken());
            if(max < res) max = res;
        }
        System.out.println(max);
    }
    public static void BKJ1112_6() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        int k = Integer.parseInt(tok.nextToken());
        int a1=1,a2=1,a3=1;
        count = 1;
        while(!(a1==n && a2 == m && a3 == k)){
            a1++;
            if(a1==16) a1 = 1;
            a2++;
            if(a2==29) a2 = 1;
            a3++;
            if(a3==20) a3 =1;
            count++;
        }
        Write.write(count+"");
        Write.flush();

    }
    public static void BKJ1112_5() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        dcarr = new char[h][w];
        for(int i=0;i<h;i++){
            dcarr[i] = Read.readLine().toCharArray();
        }
        set = new HashSet<Character>();
        int count = BKJ1112_5_btk(0,0,0);
        Write.write(count+"");
        Write.flush();
    }
    static HashSet<Character> set;
    public static int BKJ1112_5_btk(int hi, int wi, int counts){
        if(set.contains(dcarr[hi][wi])) return counts;
        counts++;
        int cc = 0;
        set.add(dcarr[hi][wi]);
        if(hi>0 && !set.contains(dcarr[hi-1][wi])) cc = Math.max(BKJ1112_5_btk(hi-1,wi,counts), cc);
        if(wi>0 && !set.contains(dcarr[hi][wi-1])) cc = Math.max(BKJ1112_5_btk(hi,wi-1,counts), cc);
        if(hi<h-1 && !set.contains(dcarr[hi+1][wi])) cc = Math.max(BKJ1112_5_btk(hi+1,wi,counts), cc);
        if(wi<w-1 && !set.contains(dcarr[hi][wi+1])) cc = Math.max(BKJ1112_5_btk(hi,wi+1,counts), cc);
        set.remove(dcarr[hi][wi]);
        return cc+1;
    }
    public static void BKJ1112_4() throws Exception {
        n = Integer.parseInt(Read.readLine());
        dcarr = new char[n][n];
        int[] arr = new int[2];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) dcarr[i][j] = tok.nextToken().charAt(0);
        }
        int[] output = BKJ1112_4_dq(n,0,0);
        Write.write(output[0]+"");
        Write.newLine();
        Write.write(output[1]+"");
        Write.flush();
    }
    public static int[] BKJ1112_4_dq(int size, int wi, int hi) {
        int[] cur = new int[2];
        if(size == 1) {
            cur[dcarr[hi][wi]-'0'] = 1;
        } else {
            int[] temrr;
            temrr = BKJ1112_4_dq(size/2,wi,hi);
            for(int i=0;i<2;i++) cur[i] += temrr[i];

            temrr = BKJ1112_4_dq(size/2,wi+(size/2),hi);
            for(int i=0;i<2;i++) cur[i] += temrr[i];

            temrr = BKJ1112_4_dq(size/2,wi,hi+(size/2));
            for(int i=0;i<2;i++) cur[i] += temrr[i];

            temrr = BKJ1112_4_dq(size/2,wi+(size/2),hi+(size/2));
            for(int i=0;i<2;i++) cur[i] += temrr[i];

            if(cur[0] == 4 && cur[1] == 0) cur[0] = 1;
            else if(cur[0] == 0 && cur[1] == 4) cur[1] = 1;
        }
        return cur;
    }
    public static void BKJ1112_3() throws Exception {
        darr = new int[8][2];
        for(int i=0;i<8;i++){
            darr[i][0] = Integer.parseInt(Read.readLine());
            darr[i][1] = i+1;
        }
        int[] temp = new int[2];
        for(int i=1;i<8;i++){
            int j=i-1;
            while(j>=0 && darr[j][0] > darr[j+1][0]){
                temp = darr[j];
                darr[j] = darr[j+1];
                darr[j+1] = temp;
                j--;
            }
        }
        int sum = 0;
        for(int i=3;i<8;i++){
            sum += darr[i][0];
        }

        for(int i=4;i<8;i++){
            int j=i-1;
            while(j>=3 && darr[j][1] > darr[j+1][1]){
                temp = darr[j];
                darr[j] = darr[j+1];
                darr[j+1] = temp;
                j--;
            }
        }
        Write.write(sum+"");
        Write.newLine();
        for(int i=3;i<8;i++) Write.write(darr[i][1]+" ");
        Write.flush();
    }
    public static void BKJ1112_2() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        w = Integer.parseInt(tok.nextToken());
        h = Integer.parseInt(tok.nextToken());

        while(!(h==0 && w==0)){
            dcarr = new char[h][w];
            for(int i=0;i<h;i++){
                tok = new StringTokenizer(Read.readLine());
                for(int j=0;j<w;j++) dcarr[i][j] = tok.nextToken().charAt(0);
            }
            count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(dcarr[i][j] == '1'){
                        BKJ1112_2_BFS(i,j);
                        count++;
                    }
                }
            }
            Write.write(count+"");
            Write.newLine();
            
            tok = new StringTokenizer(Read.readLine());
            w = Integer.parseInt(tok.nextToken());
            h = Integer.parseInt(tok.nextToken());
        }
        Write.flush();
    }
    public static void BKJ1112_2_BFS(int hi, int wi)throws Exception{
        dcarr[hi][wi] = '0';
        if(hi>0){
            if(dcarr[hi-1][wi] == '1') BKJ1112_2_BFS(hi-1,wi);
            if(wi>0 && dcarr[hi-1][wi-1] == '1') BKJ1112_2_BFS(hi-1,wi-1);
            if(wi<w-1 && dcarr[hi-1][wi+1] == '1') BKJ1112_2_BFS(hi-1,wi+1);
        }
        if(hi<h-1){
            if(dcarr[hi+1][wi] == '1') BKJ1112_2_BFS(hi+1,wi);
            if(wi>0 && dcarr[hi+1][wi-1] == '1') BKJ1112_2_BFS(hi+1,wi-1);
            if(wi<w-1 && dcarr[hi+1][wi+1] == '1') BKJ1112_2_BFS(hi+1,wi+1);
        }
        if(wi>0 && dcarr[hi][wi-1] == '1') BKJ1112_2_BFS(hi,wi-1);
        if(wi<w-1 && dcarr[hi][wi+1] == '1') BKJ1112_2_BFS(hi,wi+1);

    }
    public static void BKJ1112_1() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        dcarr = new char[h][w];
        tused = new boolean[h][w][3];
        count = 0;
        darr = new int[20][2];
        n = 0;
        for(int i=0;i<h;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<w;j++) {
                dcarr[i][j] = tok.nextToken().charAt(0);
                if(dcarr[i][j] == '0') count++;
                else if(dcarr[i][j] == '2') {
                    darr[n][0] = i;
                    darr[n][1] = j;
                    n++;
                }
            }
        }
        max = 0;
        BKJ1112_DFS(0,0,3);
        Write.write(max+"");
        Write.flush();
    }
    public static int BKJ1112_1_BFS(int hi, int wi) {
        int birs = 1;
        dcper[hi][wi] = '2';
        if(hi>0 && dcper[hi-1][wi] == '0') birs += BKJ1112_BFS(hi-1,wi);
        if(hi<h-1 && dcper[hi+1][wi] == '0') birs += BKJ1112_BFS(hi+1,wi);
        if(wi>0 && dcper[hi][wi-1] == '0') birs += BKJ1112_BFS(hi,wi-1);
        if(wi<w-1 && dcper[hi][wi+1] == '0') birs += BKJ1112_BFS(hi,wi+1);
        return birs;
    }
    public static void BKJ1112_1_DFS(int hi, int wi, int k)throws Exception {
        if(k==0) {
            dcper = new char[h][w];
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++) {
                    dcper[i][j] = dcarr[i][j];
                }
            }
            int birs = 0;
            for(int i=0;i<n;i++) {
                birs += (BKJ1112_BFS(darr[i][0], darr[i][1])-1);

            }
            if(max < count-birs-3) {
                max = count-birs-3;
            }
            return;
        }
        for(int i=hi;i<h;i++){
            for(int j=0;j<w;j++){
                boolean pass = true;
                if(k==2) pass = !tused[i][j][k];
                else if(k==1) pass = !tused[i][j][k] && !tused[i][j][k+1];
                if(dcarr[i][j] == '0' && pass){
                    tused[i][j][k-1] = true;
                    dcarr[i][j] = '1';
                    BKJ1112_DFS(i,j,k-1);
                    tused[i][j][k-1] = false;
                    dcarr[i][j] = '0';
                }
            }
        }
    }
}