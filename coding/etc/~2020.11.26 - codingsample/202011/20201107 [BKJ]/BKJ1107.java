import java.io.*;
import java.util.*;

public class BKJ1107 {
    // 1. BFS https://www.acmicpc.net/problem/1697 숨바꼭질
    // 2. DFS https://www.acmicpc.net/problem/1012 유기농 배추
    // 3. 다이나믹 프로그래밍 https://www.acmicpc.net/problem/1463 1로 만들기
    // 4. 분할정복 https://www.acmicpc.net/problem/1992 쿼드트리
    // 5. 수학1 https://www.acmicpc.net/problem/2558 A+B -2
    // 6. 수학2 https://www.acmicpc.net/problem/2748 피보나치 수 2
    // 7. 수학3 https://www.acmicpc.net/problem/2747 피보나치 수 3(6번하고 코드가 똑같음)
    // 8. 수학4 https://www.acmicpc.net/problem/9461 파도반수열

    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static char[][] arr;
    static StringBuilder str;
    public static void main(String[] args) throws Exception{
       Solution();

    }
    public static void Solution() throws Exception {
        int test = Integer.parseInt(Read.readLine());
        for(int TestCase=0;TestCase<test;TestCase++){
            int n = Integer.parseInt(Read.readLine());
            long[] arr = new long[n+10];
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;
            arr[5] = 2;
            for(int i=6;i<=n;i++){
                arr[i] = arr[i-1] + arr[i-5];
            }
            Write.write(arr[n]+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void BKJ1107_MATH2A3() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        long[] arr = new long[n+5];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++) arr[i] = arr[i-1] + arr[i-2];
        System.out.println(arr[n]);
    }
    public static void BKJ1107_MATH1() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int m = Integer.parseInt(Read.readLine());
        System.out.println(n+m);
    }
    public static void BKJ1107_DivideConquer_INS() throws Exception {
        str = new StringBuilder("");
        int n = Integer.parseInt(Read.readLine());
        arr = new char[n][n];
        for(int i=0;i<n;i++){
            arr[i] = Read.readLine().toCharArray();
        }
        StringBuilder output = BKJ1107_DivideConquer_FUNC(0,0,n);
        System.out.println(output);
    }
    public static StringBuilder BKJ1107_DivideConquer_FUNC(int h, int w, int size) throws Exception {
        if(size == 1) return new StringBuilder(arr[h][w]+"");
        StringBuilder t1, t2, t3, t4;
        t1 = BKJ1107_DivideConquer_FUNC(h,w,size/2);
        t2 = BKJ1107_DivideConquer_FUNC(h,w+size/2,size/2);
        t3 = BKJ1107_DivideConquer_FUNC(h+size/2,w,size/2);
        t4 = BKJ1107_DivideConquer_FUNC(h+size/2,w+size/2,size/2);
        // System.out.println(h+"   "+w+"   "+size +"  "+t1+" "+t2+" "+t3+" "+t4);
        String temp = t1.toString();
        if((t1.compareTo(t2)==0 && t3.compareTo(t4)==0 && t1.compareTo(t3)==0) && ( temp.equals("1") || temp.equals("0"))) {
            return t1;
        } else {
            return t1.append(t2).append(t3).append(t4).insert(0, "(").append(")");
        }
    }
    public static void BKJ1107_DynamicProgramming() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int[] arr = new int[n+5];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=4;i<=n;i++){
            int thrZ = arr[i-1], secZ = arr[i-1], minO = arr[i-1];
            if(i%3==0) thrZ = arr[i/3];
            if(i%2==0) secZ = arr[i/2];
            arr[i] = Math.min(Math.min(thrZ,secZ),minO)+1;
        }
        System.out.println(arr[n]);
    }
    public static void BKJ1107_DFS() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int CurrTest = 0;CurrTest<TestCase;CurrTest++){
            tok = new StringTokenizer(Read.readLine());
            int wid = Integer.parseInt(tok.nextToken());
            int hei = Integer.parseInt(tok.nextToken());
            int cab = Integer.parseInt(tok.nextToken());
            char[][] arr = new char[hei][wid];
            for(int i=0;i<hei;i++) Arrays.fill(arr[i],'0');

            for(int i=0;i<cab;i++){
                tok = new StringTokenizer(Read.readLine());
                int n = Integer.parseInt(tok.nextToken());
                int m = Integer.parseInt(tok.nextToken());
                arr[m][n] = '1';
            }


            Stack<Integer[]> st = new Stack<Integer[]>();
            int count = 0;
            for(int w=0;w<wid;w++){
                for(int h=0;h<hei;h++){
                    if(arr[h][w] == '1'){
                        count++;
                        st.push(new Integer[]{h,w});
                        while(!st.isEmpty()){
                            Integer[] Curr = st.pop();
                            arr[Curr[0]][Curr[1]] = '0';
                            if(Curr[0]>0 && arr[Curr[0]-1][Curr[1]] == '1')
                                st.push(new Integer[]{Curr[0]-1, Curr[1]});
                            if(Curr[0]<hei-1 && arr[Curr[0]+1][Curr[1]] == '1')
                                st.push(new Integer[]{Curr[0]+1, Curr[1]});
                            if(Curr[1]>0 && arr[Curr[0]][Curr[1]-1] == '1')
                                st.push(new Integer[]{Curr[0], Curr[1]-1});
                            if(Curr[1]<wid-1 && arr[Curr[0]][Curr[1]+1] == '1')
                                st.push(new Integer[]{Curr[0], Curr[1]+1});
                        }

                        // for(int i=0;i<hei;i++){
                        //     Write.write(Arrays.toString(arr[i]));
                        //     Write.newLine();
                        // }
                        // Write.newLine();
                        // Write.newLine();
                    }
                }
            }
            Write.write(count+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static int BKJ1107_BFS() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        q.add(n);
        int tn = n;
        int time = 0;
        while(true){
            int Sec = q.size();
            for(int i=0;i<Sec;i++){
                tn = q.poll();
                // System.out.println(tn+"  "+time);
                if(tn==m) return time;
                if(tn>0 && !set.contains(tn-1)) q.offer(tn-1);
                if(tn<m && !set.contains(tn*2)) q.offer(tn*2);
                if(tn<m && !set.contains(tn+1)) q.offer(tn+1);
                set.add(tn);
            }
            time++;
        }
    }
}
