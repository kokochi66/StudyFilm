import java.io.*;
import java.util.*;

public class BKJ1106 {
    // 1. 정렬 https://www.acmicpc.net/problem/1946 신입사원
    // 2. 백트래킹 https://www.acmicpc.net/problem/1182 부분수열의 합
    // 3. 스택 https://www.acmicpc.net/problem/1725 히스토그램
    // 4. 큐 https://www.acmicpc.net/problem/18258 큐2
    // 5. 너비우선탐색 https://www.acmicpc.net/problem/7576 토마토
    
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] oper, arr;
    public static boolean[] used;
    public static int count, result, S, n;
    public static void main(String[] arg) throws Exception {
        // System.out.println(Solution());

    }
    public static int BKJ1106_BFS() throws Exception {
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[][] board = new int[m][n];
        Queue<Integer[]> q = new LinkedList<Integer[]>();
        int mino = 0, zer = 0;
        for(int i=0;i<m;i++) {
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(tok.nextToken());
                if(board[i][j] == 1) q.offer(new Integer[]{i,j});
                else if(board[i][j] == -1) mino++;
                else zer++;
            }
        }
        if(q.isEmpty()) return -1;
        else if(q.size()+mino == n*m) return 0;

        int thday = 0;
        while(!q.isEmpty()){
            thday++;
            int work = q.size();
            // System.out.println(work);
            for(int i=0;i<work;i++){
                Integer[] Curr = q.poll();
                if(Curr[0]-1>=0 && board[Curr[0]-1][Curr[1]] == 0){
                    q.offer(new Integer[]{Curr[0]-1, Curr[1]});
                    board[Curr[0]-1][Curr[1]] = 1;
                    zer--;
                }
                if(Curr[0]+1<m && board[Curr[0]+1][Curr[1]] == 0) {
                    q.offer(new Integer[]{Curr[0]+1, Curr[1]});
                    board[Curr[0]+1][Curr[1]] = 1;
                    zer--;
                }
                if(Curr[1]-1>=0 && board[Curr[0]][Curr[1]-1] == 0) {
                    q.offer(new Integer[]{Curr[0], Curr[1]-1});
                    board[Curr[0]][Curr[1]-1] =1;
                    zer--;
                }
                if(Curr[1]+1<n && board[Curr[0]][Curr[1]+1] == 0) {
                    q.offer(new Integer[]{Curr[0], Curr[1]+1});
                    board[Curr[0]][Curr[1]+1] = 1;
                    zer--;
                }
            }
        }
        return zer==0 ? thday-1 : -1;
    }
    public static void BKJ1106_Queue() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        StringTokenizer tok;
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int TestCase = 0; TestCase<n;TestCase++){
            tok = new StringTokenizer(Read.readLine());
            String Comd = tok.nextToken();

            if(Comd.equals("push")) q.push(Integer.parseInt(tok.nextToken()));
            else if(Comd.equals("pop")){
                if(q.isEmpty())  Write.write("-1");
                else Write.write(q.remove(q.size()-1)+"");
                Write.newLine();
            } else if(Comd.equals("size")) {
                Write.write(q.size()+"");
                Write.newLine();
            } else if(Comd.equals("empty")) {
                if(q.isEmpty()) Write.write("1");
                else Write.write("0");
                Write.newLine();
            } else if(Comd.equals("front")) {
                if(q.isEmpty()) Write.write("-1");
                else Write.write(q.get(q.size()-1)+"");
                Write.newLine();
            } else if(Comd.equals("back")) {
                if(q.isEmpty()) Write.write("-1");
                else Write.write(q.get(0)+"");
                Write.newLine();
            }
        }
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1106_Stack() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(Read.readLine());
        }
        Stack<Integer[]> st = new Stack<Integer[]>();
        int index = 0, max =0;
        for(int i=0;i<=n;i++){
            if(i==n){
                while(!st.isEmpty()){
                    Integer[] tArr = st.pop();
                    int Curr = (i - tArr[0]) *tArr[1];
                    if(max<Curr) max = Curr;
                }
            } else if(st.isEmpty() || st.peek()[1] < arr[i]) st.push(new Integer[]{i,arr[i]});
            else if(st.peek()[1] > arr[i]) {
                while(!st.isEmpty() && st.peek()[1] > arr[i]){
                    Integer[] tArr = st.pop();
                    index = tArr[0];
                    int Curr = (i - tArr[0]) *tArr[1];
                    if(max<Curr) max = Curr;
                }
                st.push(new Integer[]{index,arr[i]});
            }

        }
        System.out.println(max);
    }
    public static void BKJ1106_BTK_FUNC() throws Exception {
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        S = Integer.parseInt(tok.nextToken());
        oper = new int[n];
        tok = new StringTokenizer(Read.readLine());
        count = 0;
        for(int i=0;i<n;i++) oper[i] = Integer.parseInt(tok.nextToken());
        BKJ1106_BTK_BTK(0);
        Write.write(count+"");;
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1106_BTK_BTK(int k){
        if(result == S && k>0) {
            count++;
        }
        for(int i=k;i<n;i++){
            result += oper[i];
            BKJ1106_BTK_BTK(i+1);
            result -= oper[i];
        }
    }
    public static void BKJ1106_Sort() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int ThisCase=0;ThisCase<TestCase;ThisCase++){
            int NumberPerson = Integer.parseInt(Read.readLine());
            int[][] grade = new int[NumberPerson][2];
            for(int Person=0;Person<NumberPerson;Person++){
                StringTokenizer tok = new StringTokenizer(Read.readLine());
                grade[Person][0] = Integer.parseInt(tok.nextToken());
                grade[Person][1] = Integer.parseInt(tok.nextToken());
            }
            // 입력 완료
            // 힙정렬로 소화
            int[] temp = new int[2];
            for(int i=1;i<NumberPerson;i++){
                int c=i, root;
                do {
                    root = (c-1)/2;
                    if(grade[root][0] < grade[c][0]){
                        temp = grade[root];
                        grade[root] = grade[c];
                        grade[c] = temp;
                    }
                    c = root;
                } while(c!=0);
            }
            for(int i=NumberPerson-1;i>=0;i--){
                temp = grade[i];
                grade[i] = grade[0];
                grade[0] = temp;
                int c=0, next;
                do {
                    next = (c*2)+1;
                    if(next+1<i && grade[next][0] < grade[next+1][0]) next++;
                    if(next<i && grade[next][0] > grade[c][0]){
                        temp = grade[c];
                        grade[c] = grade[next];
                        grade[next] = temp;
                    }
                    c= next;
                } while(c<i);
            }

            int count = 1, best=0;
            for(int i=1;i<NumberPerson;i++){
                if(grade[best][1] > grade[i][1]){
                    best = i;
                    count++;
                }
            }
            // for(int i=0;i<NumberPerson;i++) {
            //     Write.write(Arrays.toString(grade[i]));
            //     Write.newLine();
            // }
            Write.write(count+"");
            Write.newLine();
            // Write.newLine();
        }
        Write.flush();
        Write.close();
        Read.close();
    }
}

