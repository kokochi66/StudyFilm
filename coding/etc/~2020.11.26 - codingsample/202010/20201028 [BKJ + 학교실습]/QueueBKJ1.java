
import java.io.*;
import java.util.*;

public class QueueBKJ1 {
    // 1. https://www.acmicpc.net/problem/10845 큐
    // 2. https://www.acmicpc.net/problem/1158 요세푸스 문제
    public static void main(String[] args) throws Exception{
        // Solution();
    }
    public static void QueueBKJ1_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<Integer>();

        String input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            input = Read.readLine();
            String[] tok = input.split(" ");
            if(tok[0].equals("push")) que.add(Integer.parseInt(tok[1]));
            else if(tok[0].equals("pop")){
                if(que.isEmpty()) Write.write("-1");
                else Write.write(que.poll()+"");
                Write.newLine();
            }
            else if(tok[0].equals("size")){
                Write.write(que.size()+"");
                Write.newLine();
            }
            else if(tok[0].equals("empty")){
                if(que.isEmpty()) Write.write("1");
                else Write.write("0");
                Write.newLine();
            }
            else if(tok[0].equals("front")){
                if(que.isEmpty()) Write.write("-1");
                else Write.write(que.peek()+"");
                Write.newLine();
            }
            else if(tok[0].equals("back")){
                if(que.isEmpty()) Write.write("-1");
                else Write.write(que.toArray()[que.size()-1]+"");
                Write.newLine();
            }
        }
        
        Write.flush();
        Read.close();
        Write.close();
    }
    public static void QueueBKJ1_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<Integer>();

        String input = Read.readLine();
        String[] tok = input.split(" ");
        int n = Integer.parseInt(tok[0]);
        int k = Integer.parseInt(tok[1]);
        int[] arr = new int[n];
        int arrNum = 0;

        for(int i=1;i<=n;i++){
            que.offer(i);
        }

        while(!que.isEmpty()){
            for(int i=0;i<k-1;i++){
                que.offer(que.poll());
            }
            arr[arrNum++] = que.poll();
        }
        Write.write("<");
        for(int i=0;i<n;i++){
            Write.write(arr[i]+"");
            if(i!=n-1)Write.write(", ");
        }
        Write.write(">");
        
        Write.flush();
        Read.close();
        Write.close();
    }

}
