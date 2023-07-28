import java.io.*;
import java.util.*;

public class BKJ1103 {
    // 1. BFS&DFS https://www.acmicpc.net/problem/1260 BFS와 DFS
    // 2. DFS https://www.acmicpc.net/problem/2667 단지번호 붙이기
    // 3. 스택 https://www.acmicpc.net/problem/1918 후위 표기식
    // 4. 큐 https://www.acmicpc.net/problem/3190 뱀
    // 5. 정렬 https://www.acmicpc.net/problem/11656 접미사 배열

    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        // Solution();
        
    }
    public static void BKJ1103_SORT() throws Exception{
        PriorityQueue<String> PQ = new PriorityQueue<String>();
        StringBuilder input = new StringBuilder(Read.readLine());
        int n = input.length();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            PQ.offer(input.substring(i,n));
        }

        while(!PQ.isEmpty()){
            Write.write(PQ.poll());
            Write.newLine();
        }
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1103_QUEUE() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i], 'x');
        board[0][0] = 'b';
        // 보드생성

        StringTokenizer tok;
        input = Read.readLine();
        int appleCount = Integer.parseInt(input);
        for(int i=0;i<appleCount;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken())-1, c2 = Integer.parseInt(tok.nextToken())-1;
            board[c1][c2] = 'a';
        }
        // 사과위치 초기화

        input = Read.readLine();
        int CommandCount = Integer.parseInt(input);
        Queue<Integer[]> CC = new LinkedList<Integer[]>();
        Queue<Integer[]> CMC = new LinkedList<Integer[]>();
        for(int i=0;i<CommandCount;i++){
            tok = new StringTokenizer(Read.readLine());
            int x = Integer.parseInt(tok.nextToken()), y;
            String var1 = tok.nextToken();
            if(var1.equals("D")) y = -1;
            else y = -2;
            CC.offer(new Integer[]{x,y});
        }
        // 커맨드 초기화

        int time = 0;
        int[][] CM = new int[4][2];
        CM[0][0] = 0;
        CM[0][1] = 1;
        CM[1][0] = 1;
        CM[1][1] = 0;
        CM[2][0] = 0;
        CM[2][1] = -1;
        CM[3][0] = -1;
        CM[3][1] = 0;
        int CurrCM = 0;
        int[][] SS = new int[2][2];
        SS[0][0] = 0;
        SS[0][1] = 0;
        SS[1][0] = 0;
        SS[1][1] = 0;

        boolean GAMEOVER = false;

        while(!GAMEOVER){
            time++;
            SS[0][0] += CM[CurrCM][0];
            SS[0][1] += CM[CurrCM][1];
            CMC.add(new Integer[]{CM[CurrCM][0], CM[CurrCM][1]});
            if(SS[0][0]>=0 && SS[0][1]>=0 && SS[0][0]<n && SS[0][1]<n && board[SS[0][0]][SS[0][1]] != 'b'){
                // System.out.println(time+"   "+SS[0][0]+" "+SS[0][1]+"   "+board[SS[0][0]][SS[0][1]]);
                if(board[SS[0][0]][SS[0][1]] != 'a') {
                    board[SS[1][0]][SS[1][1]] = 'x';
                    SS[1][0] += CMC.peek()[0];
                    SS[1][1] += CMC.peek()[1];
                    CMC.poll();
                }
                board[SS[0][0]][SS[0][1]] = 'b';
                // for(int i=0;i<n;i++) System.out.println(Arrays.toString(board[i]));

                if(!CC.isEmpty() && CC.peek()[0] == time){
                    int COMAND = CC.poll()[1];
                    if(COMAND == -1){
                        CurrCM = (CurrCM+1)%4;
                    } else if(COMAND == -2){
                        CurrCM--;
                        if(CurrCM==-1) CurrCM=3;
                    }
                }
                // System.out.println("::::::::::::::::::::::::::::::  " + time);
            } else GAMEOVER = true;
        }

        Write.write(time+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1103_STACK() throws Exception{
        char[] arr = Read.readLine().toCharArray();
        Stack<Character> oper = new Stack<Character>();
        for(int i=0;i<arr.length;i++){
            char Curr = arr[i];
            char stk='x';
            if(!oper.isEmpty()) stk=oper.peek();

            if(Curr=='(') oper.push(Curr);
            else if(Curr == '+' || Curr == '-'){
                while(stk == '+' || stk == '-' || stk == '*' || stk == '/'){
                    Write.write(stk+"");
                    oper.pop();
                    stk = 'n';
                    if(!oper.isEmpty()) stk=oper.peek();
                }
                oper.push(Curr);
            } else if(Curr == '/' || Curr == '*'){
                if(stk == '*' || stk == '/'){
                    Write.write(stk+"");
                    oper.pop();
                }
                oper.push(Curr);
            } else if(Curr == ')'){
                while(stk!='('){
                    Write.write(stk+"");
                    oper.pop();
                    stk=oper.peek();
                }
                oper.pop();
            } else {
                // 알파벳은 바로 출력문에 추가
                Write.write(Curr+"");
            }
        }
        while(!oper.isEmpty()) Write.write(oper.pop()+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1103_DFS_2() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        char[][] AC = new char[n][n];
        for(int i=0;i<n;i++){
            AC[i] = Read.readLine().toCharArray();
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(AC[i][j] == '1'){
                    count++;
                    list.add(BKJ1103_DFS_2_Func(AC,i,j));
                }
            }
        }
        // 단지수를 리스트에 저장, 총 개수는 count에 저장
        
        int temp;
        for(int i=1;i<list.size();i++){
            int j=i;
            while(j>0 && list.get(j-1) > list.get(j)){
                temp = list.get(j-1);
                list.set(j-1, list.get(j));
                list.set(j, temp);
                j--;
            }
        }
        //입력된 리스트를 오름차순으로 정렬

        Write.write(count+"");
        Write.newLine();
        for(int i=0;i<list.size();i++) {
            Write.write(list.get(i)+"");
            Write.newLine();
        }
        // 출력부분

        Write.flush();
        Write.close();
        Read.close();
    }
    public static int BKJ1103_DFS_2_Func(char[][] arr, int h, int w){
        if(h<0 || h>=arr.length || w<0 || w>=arr[0].length || arr[h][w] == '0') return 0;
        int sum = 1;
        arr[h][w] = '0';
        sum += BKJ1103_DFS_2_Func(arr,h+1,w);
        sum += BKJ1103_DFS_2_Func(arr,h-1,w);
        sum += BKJ1103_DFS_2_Func(arr,h,w+1);
        sum += BKJ1103_DFS_2_Func(arr,h,w-1);
        return sum;
    }
    public static void BKJ1103_DFS_AND_BFS() throws Exception {
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int v = Integer.parseInt(tok.nextToken());
        boolean[][] edges = new boolean[n][n];
        //선언 부
        for(int i=0;i<n;i++) Arrays.fill(edges[i], false);
        //edge배열 초기화

        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken())-1, c2 = Integer.parseInt(tok.nextToken())-1;
            edges[c1][c2] = true;
            edges[c2][c1] = true;
        }
        //입력된 edge를 v와 연결

        //1. 스택을 사용한 깊이우선탐색
        HashSet<Integer> set = new HashSet<Integer>();
        Stack<Integer> stk = new Stack<Integer>();
        Write.write(v+" ");
        stk.push(v);
        set.add(v);
        while(!stk.isEmpty()){
            int index = 0, Curr = stk.peek();
            while(index<n && (!edges[Curr-1][index] || set.contains(index+1))) index++;
            if(index >= n){
                stk.pop();
            } else {
                Write.write((index+1)+" ");
                stk.push((index+1));
                set.add(index+1);
            }
        }
        Write.newLine();
        set.clear();

        //2. 큐를 사용한 너비우선탐색
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(v);
        set.add(v);
        Write.write(v+" ");
        while(!que.isEmpty()){
            int Curr = que.poll();
            for(int i=0;i<n;i++){
                if(edges[Curr-1][i] && !set.contains(i+1)) {
                    que.offer(i+1);
                    set.add(i+1);
                    Write.write((i+1)+" ");
                }
            }
        }

        Write.flush();
        Write.close();
        Read.close();
    }


}
