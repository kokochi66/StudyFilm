import java.io.*;
import java.util.*;

public class BKJ1104_t {

    // 1. https://www.acmicpc.net/problem/9663 N-Queen
    // 2. https://www.acmicpc.net/problem/14888 연산자 끼워넣기
    // 3. https://www.acmicpc.net/problem/6603 로또
    // 4. https://www.acmicpc.net/problem/15649 N과 M(1)
    // 5. https://www.acmicpc.net/problem/14889 스타트와 링크
    // 6. https://www.acmicpc.net/problem/1182 부분 수열의 합

    public static int[] arr;
    public static int[] oper;
    public static int n, m, min, max, result;
    public static boolean[] used;
    public static int[][] darr;
    public static boolean[][] dused;
    public static int Count;
    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        // Solution();
    }
    public static void BKJ1104_BTK6_FUNC() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        int S = Integer.parseInt(tok.nextToken());
        oper = new int[n];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) oper[i] = Integer.parseInt(tok.nextToken());
        result = 0;
        Count = 0;
        BKJ1104_BTK6_BTK(S,0);

        Write.write(Count+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1104_BTK6_BTK(int S, int ci) {
        if(result == S && ci<n && ci!=0){
            // System.out.println(result +" "+ci+"  "+oper[ci]+"   "+Count);
            Count++;
        } else if (ci==0){
            for(int i=0;i<n;i++){
                result += oper[i];
                BKJ1104_BTK6_BTK(S,i+1);
                // System.out.println("최초출력 :::::::::::::::: "+i);
                result -= oper[i];
            }
        }
        if(ci<n && ci>0) {
            result += oper[ci];
            BKJ1104_BTK6_BTK(S,ci+1);
            result -= oper[ci];
        }
    }
    public static void BKJ1104_BTK5_FUNC() throws Exception {
        n = Integer.parseInt(Read.readLine());
        arr = new int[n/2];
        used = new boolean[n];
        darr = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) darr[i][j] = Integer.parseInt(tok.nextToken());
        }
        min = 999999999;

        BKJ1104_BTK5_BTK(0,0);

        Write.write(min+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1104_BTK5_BTK(int k, int ci) throws Exception{
        if(k==(n/2)){
            int teamA=0, teamB=0, index = 0, arrind =0;
            int[] Bsquad = new int[n/2];
            for(int i=0;i<n;i++){
                if(arrind<(n/2) && arr[arrind] == i) {
                    arrind++;
                    int j=arrind-2;
                    while(j>=0){
                        teamA += darr[i][arr[j]];
                        teamA += darr[arr[j]][i];
                        j--;
                    }
                } else {
                    Bsquad[index++] = i;
                    int j=index-2;
                    while(j>=0){
                        teamB += darr[i][Bsquad[j]];
                        teamB += darr[Bsquad[j]][i];
                        j--;
                    }
                }
            }
            if(min>Math.abs(teamA-teamB)) min = Math.abs(teamA-teamB);
            // Write.write(Arrays.toString(arr)+"  "+teamA+"  "+teamB);
            // Write.newLine();
        } else {
            for(int i=ci;i<n;i++){
                if(!used[i]) {
                    used[i] = true;
                    arr[k] = i;
                    BKJ1104_BTK5_BTK(k+1, i+1);
                    used[i] = false;
                }
            }
        }
    }
    public static void BKJ1104_BTK4_FUNC() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        oper = new int[n];
        arr = new int[m];
        used = new boolean[n];
        for(int i=1;i<=n;i++) oper[i-1] = i;
        BKJ1104_BTK4_BTK(0);

        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1104_BTK4_BTK(int k) throws Exception {
        if(k==m){
            for(int i=0;i<m;i++) Write.write(arr[i]+" ");
            Write.newLine();
        } else {
            for(int i=0;i<n;i++){
                if(!used[i]){
                    arr[k] = oper[i];
                    used[i] = true;
                    BKJ1104_BTK4_BTK(k+1);
                    used[i] = false;
                }
            }
        }
    }
    public static void BKJ1104_BTK3_FUNC()throws Exception {
        String input = Read.readLine();
        while(!input.equals("0")){
            tok = new StringTokenizer(input);
            n = Integer.parseInt(tok.nextToken());
            oper = new int[n];
            for(int i=0;i<n;i++) oper[i] = Integer.parseInt(tok.nextToken());
            Arrays.sort(oper);
            // 배열 입력

            arr = new int[6];
            used = new boolean[n];
            m = 6;
            BKJ1104_BTK3_BTK(0, 0);
            Write.newLine();
            input = Read.readLine();
        }
        Write.flush();
        Write.close();
        Read.close();

    }
    public static void BKJ1104_BTK3_BTK(int k, int ci) throws Exception {
        if(k==m){
            for(int i=0;i<m;i++) Write.write(arr[i]+" ");
            Write.newLine();
        } else {
            for(int i=ci;i<n;i++){
                if(!used[i]){
                    arr[k] = oper[i];
                    used[i] = true;
                    BKJ1104_BTK3_BTK(k+1, i+1);
                    used[i] = false;
                }
            }
        }
    }
    public static void BKJ1104_BTK2_FUNC()throws Exception {
        n = Integer.parseInt(Read.readLine());
        arr = new int[n];
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
        //배열 초기화

        m = 0;
        oper = new int[4];
        // +, -, *, /
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<4;i++) {
            oper[i] = Integer.parseInt(tok.nextToken());
            m += oper[i];
        }
        min = 999999999;
        max = -999999999;

        result = arr[0];
        BKJ1104_BTK2_BTK(0, 1);

        Write.write(max+"");
        Write.newLine();
        Write.write(min+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1104_BTK2_BTK(int k, int num){
        if(k==m){
            if(result < min) min = result;
            if(result > max) max = result;
        } else {
            for(int i=0;i<4;i++){
                if(i==0 && oper[i]>0) {
                    result += arr[num];
                    oper[i]--;
                    BKJ1104_BTK2_BTK(k+1,num+1);
                    result -= arr[num];
                    oper[i]++;
                } else if (i==1 && oper[i]>0) {
                    result -= arr[num];
                    oper[i]--;
                    BKJ1104_BTK2_BTK(k+1,num+1);
                    result += arr[num];
                    oper[i]++;
                } else if (i==2 && oper[i]>0) {
                    result *= arr[num];
                    oper[i]--;
                    BKJ1104_BTK2_BTK(k+1,num+1);
                    result /= arr[num];
                    oper[i]++;
                } else if (i==3 && oper[i]>0) {
                    int temp = result;
                    result /= arr[num];
                    oper[i]--;
                    BKJ1104_BTK2_BTK(k+1,num+1);
                    result = temp;
                    oper[i]++;
                } 
            }
        }
    }
    public static void BKJ1104_BTK1_FUNC() throws Exception {
        int input = Integer.parseInt(Read.readLine());
        n = 0;
        m = input;
        Count = 0;
        dused = new boolean[3][(input*2)-1];
        BKJ1104_BTK1_BTK(0,0);

        Write.write(Count+"");
        Write.flush();
        Read.close();
        Write.close();
    }  
    public static void BKJ1104_BTK1_BTK(int k, int ci){
        if(k==m){
            Count++;
        } else {
            for(int j=0;j<m;j++){
                if(!dused[0][j] && !dused[1][ci+j] && !dused[2][m+ci-j-1]) {
                    dused[0][j] = true;
                    dused[1][ci+j] = true;
                    dused[2][m+ci-j-1] = true;

                    BKJ1104_BTK1_BTK(k+1, ci+1);

                    dused[0][j] = false;
                    dused[1][ci+j] = false;
                    dused[2][m+ci-j-1] = false;
                }

            }
        }
    }
}
