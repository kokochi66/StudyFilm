import java.util.*;
import java.io.*;
// 1. 스택 https://www.acmicpc.net/problem/1935  후위 표기식 2
// 2. 백트래킹 https://www.acmicpc.net/problem/15650    N과 M(2)
// 3. 수학 https://www.acmicpc.net/problem/10953 A+B -6
// 4. 수학2 https://www.acmicpc.net/problem/1934 최소공배수
// 5. 수학3 https://www.acmicpc.net/problem/2609 최대공약수와 최소공배수
// 6. 수학4 https://www.acmicpc.net/problem/2163 초콜릿 자르기

public class BKJ1110 {
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
    public static void BKJ1110_Fluyd() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        darr = new int[n+1][n+1];
        doper = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(doper[i], 99999);
        }
        arr = new int[n+1];
        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine()); 
            int xi = Integer.parseInt(tok.nextToken()), yi = Integer.parseInt(tok.nextToken());
            darr[xi][yi] = 1;
            darr[yi][xi] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j && darr[i][j] == 1){
                    Queue<Integer[]> q = new LinkedList<>();
                    used = new boolean[n+1];
                    used[i] = true;
                    Integer[] Curr = new Integer[2];
                    q.offer(new Integer[]{j,2});
                    while(!q.isEmpty()){
                        Curr = q.poll();
                        if(doper[i][Curr[0]] > Curr[1]) doper[i][Curr[0]] = Curr[1];
                        used[Curr[0]] = true;
                        int index = 0;
                        while(index<=n) {
                            if(darr[Curr[0]][index] == 1 && !used[index]) q.offer(new Integer[]{index,Curr[1]+1});
                            index++;
                        }

                    }
                }
            }
        }
        int min = 99999;
        int minp = n;
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=n;j++){
                if(doper[i][j]<10000) sum += doper[i][j];
            }
            if(sum < min) {
                min = sum;
                minp = i;
            }
        }
        System.out.println(minp);
        // for(int i=1;i<=n;i++) System.out.println(Arrays.toString(doper[i]));
    }
    public static void BKJ1110_DC() throws Exception {
        n = Integer.parseInt(Read.readLine());
        darr = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) darr[i][j] = Integer.parseInt(tok.nextToken());
        }
        int[] output = BKJ1110_DC_DC(n,0,0);
        Write.write(output[0]+"");
        Write.newLine();
        Write.write(output[1]+"");
        Write.newLine();
        Write.write(output[2]+"");
        Write.flush();
    }
    public static int[] BKJ1110_DC_DC(int size, int hi, int wi) throws Exception {
        int[] count = new int[3];
        if(size == 1){
            count[darr[hi][wi]+1]++;
        } else {
            int[] temp = new int[3];
            temp = BKJ1110_DC_DC(size/3, hi, wi);
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi, wi+(size/3));
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi, wi+((size/3)*2));
            for(int i=0;i<3;i++) count[i] += temp[i];

            temp = BKJ1110_DC_DC(size/3, hi+(size/3), wi);
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi+(size/3), wi+(size/3));
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi+(size/3), wi+((size/3)*2));
            for(int i=0;i<3;i++) count[i] += temp[i];

            temp = BKJ1110_DC_DC(size/3, hi+((size/3)*2), wi);
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi+((size/3)*2), wi+(size/3));
            for(int i=0;i<3;i++) count[i] += temp[i];
            temp = BKJ1110_DC_DC(size/3, hi+((size/3)*2), wi+((size/3)*2));
            for(int i=0;i<3;i++) count[i] += temp[i];
            if(count[0]==9 && count[1]==0 && count[2]==0) count[0] = 1;
            else if(count[1]==9 && count[0]==0 && count[2]==0) count[1] = 1;
            else if(count[2]==9 && count[1]==0 && count[0]==0) count[2] = 1;
        }
        return count; 
    }
    public static void BKJ1110_Math4() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        int max = Math.max(m, n);
        int min = Math.min(m,n);
        System.out.println((min-1)+((max-1)*min));
    }
    public static void BKJ1110_Math3() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        long n = Integer.parseInt(tok.nextToken());
        long m = Integer.parseInt(tok.nextToken());
        long res = BKJ1110_Euclidean_GL(n,m);
        Write.write((n*m/res)+"");
        Write.newLine();
        Write.write(res+"");
        Write.flush();
    }
    public static void BKJ1110_Math2() throws Exception {
        int test = Integer.parseInt(Read.readLine());
        for(int i=0;i<test;i++){
            tok = new StringTokenizer(Read.readLine());
            long n = Integer.parseInt(tok.nextToken());
            long m = Integer.parseInt(tok.nextToken());
            Write.write(BKJ1110_Euclidean_GL(n,m)+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static long BKJ1110_Euclidean_GL(long a, long b) throws Exception {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        long res = 0;
        while(min>0){
            long pset = max/min;
            long nset = max%min;
            if(nset == 0){
                res = min;
                break;
            }
            max = min;
            min = nset;
        }
        // 최소공배수 = (a*b)/res
        // 최대공약수 = res
        return (long)(a*b)/(long)res;
    }
    public static void BKJ1110_Math1() throws Exception {
        int test = Integer.parseInt(Read.readLine());
        for(int i=0;i<test;i++){
            tok = new StringTokenizer(Read.readLine(),",");
            n = Integer.parseInt(tok.nextToken());
            m = Integer.parseInt(tok.nextToken());
            Write.write((n+m)+"");
            Write.newLine();
        }
        Write.flush();
    
    }
    public static void BKJ1110_BTK_FUNC() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        oper = new int[m];
        BKJ1110_BTK_BTK(0,1);
        Write.flush();
    }
    public static void BKJ1110_BTK_BTK(int k, int ci) throws Exception {
        if(k == m){
            for(int i=0;i<m;i++) Write.write(oper[i]+" ");
            Write.newLine();
        } else {
            for(int i=ci;i<=n;i++){
                oper[k] = i;
                BKJ1110_BTK_BTK(k+1, i+1);
            }
        }
    }
    public static void BKJ1110_Stack() throws Exception {
        n = Integer.parseInt(Read.readLine());
        StringBuilder input = new StringBuilder(Read.readLine());
        double[] arr = new double[n];
        double[] reg = new double[100];
        int regP = 0;
        for(int i=0;i<n;i++){
            arr[i] = Double.parseDouble(Read.readLine());
        }
        // 입력부

        Stack<Character> st = new Stack<>();
        for(int i=0;i<input.length();i++){
            char Curr = input.charAt(i);
            if(Curr == '+' || Curr == '-' || Curr == '*' || Curr == '/'){
                if(st.size()>=2){
                    double op1=0,op2=0;
                    char AL2 = st.pop();
                    if(AL2<='Z') op2 = arr[AL2-'A'];
                    else op2 = reg[AL2-'a'];

                    char AL1 = st.pop();
                    if(AL1<='Z') op1 = arr[AL1-'A'];
                    else op1 = reg[AL1-'a'];

                    double temp=0;
                    if(Curr == '+') temp = op1 + op2;
                    else if(Curr == '-') temp = op1 - op2;
                    else if(Curr == '*') temp = op1 * op2;
                    else if(Curr == '/') temp = op1 / op2;
                    reg[regP] = temp;
                    // System.out.println(temp +"  현재 연산 = "+Curr);
                    st.push((char)(regP+'a'));
                    regP++;
                } else {
                    System.out.println("Error :: Wrong Expression");
                    return;
                }

            } else st.push(Curr);
        }
        double res = 0;
        if(st.peek()<='Z') res = arr[st.peek()-'A'];
        else res = reg[st.peek()-'a'];
        System.out.printf("%.2f",res);

    }
}
