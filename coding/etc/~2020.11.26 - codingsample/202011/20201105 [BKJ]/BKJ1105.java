import java.io.*;
import java.util.*;

public class BKJ1105 {
    // 1. 정렬 https://www.acmicpc.net/problem/10825 국영수
    // 2. 큐 https://www.acmicpc.net/problem/11866 요세푸스 문제0
    // 3. 스택 https://www.acmicpc.net/problem/3986 좋은 단어
    // 4. BFS https://www.acmicpc.net/problem/2178 미로탐색
    // 5. DFS https://www.acmicpc.net/problem/2606 바이러스

    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tok;
    public static void main(String[] args)throws Exception {
        // Solution();
    }

    public static void BKJ1105_DFS() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int Case = Integer.parseInt(Read.readLine());
        boolean[][] edges = new boolean[n+1][n+1];
        for(int i=0;i<Case;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken());
            int c2 = Integer.parseInt(tok.nextToken());
            edges[c1][c2] = true;
            edges[c2][c1] = true;
        }
        // 입력부

        Stack<Integer> st = new Stack<Integer>();
        boolean[] used = new boolean[n+1];
        st.push(1);
        used[1] = true;
        int count = 0;
        // 선언부

        while(!st.isEmpty()){
            int Curr = st.peek();
            int next = -1;
            for(int i=1;i<=n;i++){
                if(edges[Curr][i] && !used[i]){
                    next = i;
                    break;
                }
            }
            if(next == -1){
                st.pop();
            } else {
                st.push(next);
                used[next] = true;
                count++;
            }
        }

        // for(int i=0;i<=n;i++){
        //     Write.write(Arrays.toString(edges[i]));
        //     Write.newLine();
        // }
        Write.write(count+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1105_BFS() throws Exception {
        tok = new StringTokenizer(Read.readLine()); 
        int x = Integer.parseInt(tok.nextToken());
        int y = Integer.parseInt(tok.nextToken());
        char[][] arr = new char[x][y];
        int[][] weight = new int[x][y];
        for(int i=0;i<x;i++){
            arr[i] = Read.readLine().toCharArray();
            Arrays.fill(weight[i], 100001);
        }
        weight[0][0] = 1;
        // 입력부분

        Queue<Integer[]> que = new LinkedList<Integer[]>();
        int CX =0, CY=0;
        // 선언부

        while(!(CX==(x-1) && CY==(y-1))){
            int currW = weight[CX][CY]+1;

            if(CX-1>=0 && weight[CX-1][CY] > currW && arr[CX-1][CY] == '1') {
                que.add(new Integer[]{CX-1,CY});
                weight[CX-1][CY] = currW;
            }
            if(CY-1>=0 && weight[CX][CY-1] > currW && arr[CX][CY-1] == '1') {
                que.add(new Integer[]{CX,CY-1});
                weight[CX][CY-1] = currW;
            }
            if(CX+1<x && weight[CX+1][CY] > currW && arr[CX+1][CY] == '1') {
                que.add(new Integer[]{CX+1,CY});
                weight[CX+1][CY] = currW;
            }
            if(CY+1<y && weight[CX][CY+1] > currW && arr[CX][CY+1] == '1') {
                que.add(new Integer[]{CX,CY+1});
                weight[CX][CY+1] = currW;
            }
            Integer[] curr = que.poll();
            CX = curr[0]; 
            CY = curr[1];
        }

        // for(int i=0;i<x;i++) {
        //     Write.write(Arrays.toString(weight[i])+"");
        //     Write.newLine();
        // }
        Write.write(weight[x-1][y-1]+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1105_Stack() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int count = 0;
        for(int TestCase=0;TestCase<n;TestCase++){
            char[] Curr = Read.readLine().toCharArray();
            int len = Curr.length;
            Stack<Character> st = new Stack<>();
            for(int i=0;i<len;i++){
                if(!st.isEmpty() && st.peek() == Curr[i]){
                    st.pop();
                }
                else st.push(Curr[i]);
            }
            if(st.isEmpty()) count++;
        }
        Write.write(count+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1105_Queue() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int k = Integer.parseInt(tok.nextToken());
        Queue<Integer> que = new LinkedList<Integer>();
        int[] arr = new int[n];

        for(int i=1;i<=n;i++) que.offer(i);
        int index = 0;
        Write.write("<");
        while(!que.isEmpty()){
            index++;
            if(index==k){
                index = 0;
                Write.write(que.poll()+"");
                if(!que.isEmpty()) Write.write(", ");
            } else que.add(que.poll());
        }
        Write.write(">");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ1105_Sort() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        PriorityQueue<Student> st = new PriorityQueue<Student>();
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            String name = tok.nextToken();
            int Lan = Integer.parseInt(tok.nextToken());
            int Eng = Integer.parseInt(tok.nextToken());
            int Mat = Integer.parseInt(tok.nextToken());
            st.offer(new Student(name,Lan,Eng,Mat));
            // 국-영-수 점수
        }
        while(!st.isEmpty()){
            System.out.println(st.poll().getName());
        }
    }
    public static class Student implements Comparable<Student> {
        String name;
        int Lan, Eng, Mat;
        public Student(String n, int l, int e, int m){
            this.name = n;
            this.Lan = l;
            this.Eng = e;
            this.Mat = m;
        }
        public String getName(){
            return this.name;
        }

        @Override
        public int compareTo(Student o) {
            if(o.Lan == this.Lan){
                if(o.Eng == this.Eng) {
                    if(o.Mat == this.Mat){
                        return this.name.compareTo(o.name);
                    }
                    return this.Mat > o.Mat ? -1 : 1;
                }
                return this.Eng < o.Eng ? -1 : 1;
            }
            return this.Lan > o.Lan ? -1 : 1;
        }
    }
}
