import java.util.*;
import java.io.*;

public class KNU_week11_3 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        int st = Integer.parseInt(tok.nextToken());
        int[][] ma = new int[n][n];
        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken());
            int c2 = Integer.parseInt(tok.nextToken());
            ma[c1-1][c2-1] = 1;
            ma[c2-1][c1-1] = 1;
        }
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(ma[i]));
        //입력부 O

        Queue<data> q = new LinkedList<>();
        boolean pass = false;
        // 1.현재노드, 2.현재까지 지나온 노드, 
        q.offer(new data(st-1,n));
        while(!q.isEmpty()){
            data c = q.poll();
            for(int i=0;i<n;i++){
                if(ma[c.curr][i]==1 && !c.used[i]){
                    data temp = new data(c,n);
                    temp.go(i);
                    q.offer(temp);
                }
                if(i==st-1 && c.des == n) {
                    pass = true;
                    for(int j=0;j<n;j++) Write.write((c.broad[j]+1)+" ");
                    Write.write(st+"");
                    Write.newLine();
                }
            }
        }
        if(!pass) Write.write("0");
        Write.flush();
    }

    static class data {
        int curr, des;
        boolean[] used;
        int[] broad;

        public data(data d, int size){
            this.curr = d.curr;
            this.des = d.des;
            this.used = new boolean[size];
            this.broad = new int[size];
            for(int i=0;i<size;i++){
                this.used[i] = d.used[i];
                this.broad[i] = d.broad[i];
            }
        }
        public data(int c, int size){
            this.curr = c;
            this.des = 1;
            this.used = new boolean[size];
            this.broad = new int[size];
            used[c] = true;
            broad[0] = c;
        }
        public void go(int s){
            this.curr = s;
            this.used[s] = true;
            this.broad[des++] = s;
        }
    }
}