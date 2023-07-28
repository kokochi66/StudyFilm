
import java.io.*;
import java.util.*;

public class StackBKJ3 {
    // 1. https://www.acmicpc.net/problem/2493 탑
    public static void main(String[] args) throws Exception{
        // Solution();
    }
    public static void StackBKJ3_1() throws Exception{
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer[]> MinStack = new Stack<Integer[]>();

        // 입력되는 값들을 각각 MinStack에 저장하며 자신보다 큰 탑이 나타날때까지 0으로 유지한다.
        // 스택에는 2개짜리 배열이 저장되며, 0에는 탑의 높이, 1에는 탑의 위치값이 저장된다.
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        input = Read.readLine();
        String[] tok = input.split(" ");
        // n개의 값을 입력받는다.

        for(int i=n-1;i>=0;i--){
            //끝자리에서부터 반복
            
            int Curr = Integer.parseInt(tok[i]);
            while(!MinStack.isEmpty() && MinStack.peek()[0]<=Curr) {
                //탑의 신호를 받을 탑이 나온경우
                arr[MinStack.pop()[1]] = i+1;
            } 
            MinStack.push(new Integer[]{Curr,i});
        }
        for(int i=0;i<n;i++) Write.write(arr[i]+" ");
        Write.flush();
        Write.close();
        Read.close();
    }
}
