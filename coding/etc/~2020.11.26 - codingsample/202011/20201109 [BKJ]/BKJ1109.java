
import java.util.*;
import java.io.*;
// 1. 정렬 https://www.acmicpc.net/problem/11728 배열 합치기
// 2. 큐 https://www.acmicpc.net/problem/2161 카드1
// 3. 깊이우선탐색 https://www.acmicpc.net/problem/11724 연결요소의 개수
// 4. 플로이드-와샬 https://www.acmicpc.net/problem/11403 경로찾기
// 5. 조합론 https://www.acmicpc.net/problem/1010 다리놓기
// 6. https://www.acmicpc.net/problem/7287 등록
// 7. https://www.acmicpc.net/problem/2440 별 찍기3
// 8. https://www.acmicpc.net/problem/2441 별 찍기4
// 9. https://www.acmicpc.net/problem/1924 2007년
// 10. https://www.acmicpc.net/problem/11718 그대로 출력하기
// 11. https://www.acmicpc.net/problem/11721 10개씩 끊어 출력하기
// 12. https://www.acmicpc.net/problem/11719 그대로 출력하기 2
// 13. https://www.acmicpc.net/problem/9095 1,2,3 더하기

public class BKJ1109 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m, k;
    static long count;
    public static void main(String[] args) throws Exception {
        // Solution();
    }
    public static void BKJ1109_8() throws Exception {
        int TC = Integer.parseInt(Read.readLine());
        for(int tt=0;tt<TC;tt++){
            n = Integer.parseInt(Read.readLine());
            count = 0;
            for(int i=1;i<=3;i++){
                BKJ1109_8_btk(i);
            }
            Write.write(count+"");
            Write.newLine();
        }
        Write.flush();

    }
    public static void BKJ1109_8_btk(int kc) throws Exception {
        if(kc==n){
            count++;
        } else {
            for(int i=1;i<=3;i++){
                if(kc+i<=n){
                    BKJ1109_8_btk(kc+i);
                }
            }
        }
    }
    public static void BKJ1109_7() throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            System.out.println(input);
        }
    }
    public static void BKJ1109_6() throws Exception {
        StringBuilder s = new StringBuilder(Read.readLine());
        while(s.length()>0){
            int right = 10;
            if(s.length()<10) right = s.length();
            Write.write(s.substring(0,right));
            Write.newLine();
            s.delete(0, right);
        }
        Write.flush();
    }
    public static void BKJ1109_5() throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            System.out.println(input);
        }
    }
    public static void BKJ1109_4() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        String[] week = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int day = m;
        for(int i=1;i<n;i++) {
            if(i==2) day+=28;
            else if(i==4 || i==6 || i==9 || i==11) day+=30;
            else day +=31;
        }
        Write.write(week[(day%7)]+"");
        Write.flush();
    }
    public static void BKJ1109_3() throws Exception {
        n = Integer.parseInt(Read.readLine());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(j>=i) Write.write("*");
                else Write.write(" ");
            }
            Write.newLine();
        }
        Write.flush();
    }
    public static void BKJ1109_2() throws Exception {
        n = Integer.parseInt(Read.readLine());
        for(int i=n;i>=1;i--){
            for(int j=0;j<i;j++) Write.write("*");
            Write.newLine();
        }
        Write.flush();
    }
    public static void BKJ1109_1() throws Exception {
        Write.write("158");
        Write.newLine();
        Write.write("kkkkkkkkkjw12");
        Write.flush();
    }
    public static void BKJ1109_Comb() throws Exception {
        int TCASE = Integer.parseInt(Read.readLine());
        for(int TC=0;TC<TCASE;TC++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());
            m = Integer.parseInt(tok.nextToken());
            arr = new int[n+1];
            for(int i=1;i<=n;i++) arr[i] = (i*(i+1))/2;
            k = m-n+1;
            count = 0;
            BKJ1109_Comb_btk(1, k);
            Write.write(count+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void BKJ1109_Comb_btk(int r, int ci) throws Exception {
        // Write.write("come here  "+r+"   "+ci);
        // Write.newLine();
        if(r==n){
            count += ci;
        } else {
            for(int i=1;i<=ci;i++){
                BKJ1109_btk(r+1,i);
            }
        }
    }
    public static void BKJ1109_Fluyd() throws Exception {
        n = Integer.parseInt(Read.readLine());
        int[][] edges = new int[n][n];
        int[][] dres = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) edges[i][j] = Integer.parseInt(tok.nextToken());
        }

        for(int i=0;i<n;i++){
            Stack<Integer> st = new Stack<>();
            boolean[] used = new boolean[n];
            st.push(i);
            while(!st.isEmpty()){
                int CP = st.peek();
                int sti = 0;
                while(sti<n && !(!used[sti] && edges[CP][sti]==1)) {
                    if(edges[CP][sti]==1) dres[i][sti] = 1;
                    sti++;
                }
                if(sti>=n) st.pop();
                else {
                    dres[i][sti] = 1;
                    st.push(sti);
                    used[sti] = true;
                }
            }
            for(int j=0;j<n;j++) Write.write(dres[i][j]+" ");
            Write.newLine();
        }
        Write.flush();
    }
    public static void BKJ1109_DFS() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        dcheck = new boolean[n+1][n+1];
        used = new boolean[n+1];
        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken());
            int c2 = Integer.parseInt(tok.nextToken());
            dcheck[c1][c2] = true;
            dcheck[c2][c1] = true;
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            if(!used[i]){
                count++;
                Stack<Integer> st = new Stack<>();
                st.push(i);
                used[i] = true;
                while(!st.isEmpty()){
                    int CP = st.peek();
                    int sti = 1;
                    while(sti<=n && !(!used[sti] && dcheck[CP][sti])) sti++;
                    if(sti>n) {
                        st.pop();
                    }
                    else {
                        st.push(sti);
                        used[sti] = true;
                    }
                }
            }

        }
        Write.write(count+"");
        Write.flush();
    }
    public static void BKJ1109_Queue() throws Exception {
        n = Integer.parseInt(Read.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<=n;i++) q.offer(i);
        boolean pass = false;
        while(q.size()>1){
            if(!pass) {
                Write.write(q.poll()+" ");
                pass = true;
            }
            else {
                q.offer(q.poll());
                pass = false;
            }
        }
        Write.write(q.poll()+"");
        Write.flush();
    }
    public static void BKJ1109_Sort() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        int[] Arr = new int[n];
        int[] Brr = new int[m];
        int[] Crr = new int[n+m];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) Arr[i] = Integer.parseInt(tok.nextToken());
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<m;i++) Brr[i] = Integer.parseInt(tok.nextToken());

        int aW=0, bW=0, kW=0;
        while(aW<n && bW<m){
            if(Arr[aW] < Brr[bW]) Crr[kW++] = Arr[aW++];
            else Crr[kW++] = Brr[bW++];
        }
        while(aW<n) Crr[kW++] = Arr[aW++];
        while(bW<m) Crr[kW++] = Brr[bW++];

        for(int i=0;i<n+m;i++) Write.write(Crr[i]+" ");
        Write.flush();
    }
}
