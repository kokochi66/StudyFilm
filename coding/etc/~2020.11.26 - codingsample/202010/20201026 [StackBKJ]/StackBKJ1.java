import java.util.*;
import java.io.*;

public class StackBKJ1 {
    // 1. https://www.acmicpc.net/problem/10828 스택
    // 2. https://www.acmicpc.net/problem/9012 괄호
    // 3. https://www.acmicpc.net/problem/1874 스택 수열

    public static void main(String[] args) throws Exception{
        // Solution();
    }
    public static void StackBKJ1_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<Integer>();
        String[] Instruction = {"push","pop","size","empty","top"};
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            input = Read.readLine();
            String[] token = input.split(" ");
            int pushVar = 0;
            if(token[0].equals(Instruction[0])){
                pushVar = Integer.parseInt(token[1]);
                stack.push(pushVar);
            }
            else if(token[0].equals(Instruction[1])){
                if(stack.isEmpty()) Write.write("-1");
                else Write.write(stack.pop()+"");
                Write.newLine();
            }
            else if(token[0].equals(Instruction[2])){
                Write.write(stack.size()+"");
                Write.newLine();
            }
            else if(token[0].equals(Instruction[3])){
                if(stack.isEmpty()) Write.write("1");
                else Write.write("0");
                Write.newLine();
            }
            else if(token[0].equals(Instruction[4])){
                if(stack.isEmpty()) Write.write("-1");
                else Write.write(stack.peek()+"");
                Write.newLine();
            }
        }
        Write.newLine();
        Write.close();
        Read.close();
    }
    public static void StackBKJ1_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            Stack<Character> stack = new Stack<Character>();
            input = Read.readLine();
            for(int j=0;j<input.length();j++){
                char Curr = input.charAt(j);
                if(Curr == '('){
                    stack.add(Curr);
                } else {
                    if(stack.isEmpty()) {
                        Write.write("NO");
                        break;
                    }
                    else stack.pop();
                }

                if(j==input.length()-1 && !stack.isEmpty()) Write.write("NO");
                else if(j==input.length()-1 && stack.isEmpty()) Write.write("YES");
            }
            Write.newLine();
        }
        Write.newLine();
        Write.close();
        Read.close();
    }
    public static void StackBKJ1_3() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<Integer>();
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        int[] arrTemp = new int[n];
        char[] output = new char[n*2];
        for(int i=0;i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
            arrTemp[i] = arr[i];
        }

        // 힙정렬 최소힙으로 구현
        int temp;
        for(int i=1;i<n;i++){
            int c = i, root;
            do {
                root = (c-1)/2;
                if(arr[root] > arr[c]){
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }

        int TS = 0;
        int oN = 0;
        for(int i=n-1;i>=0;i--){
            stack.add(arr[0]);
            output[oN++] = '+';
            if(arr[0] == arrTemp[TS]){
                while(!stack.isEmpty() && stack.peek() == arrTemp[TS]){
                    TS++;
                    stack.pop();
                    output[oN++] = '-';
                }
            }
            arr[0] = arr[i];
            int c=0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next+1] < arr[next]) next++;
                if(next<i && arr[c] > arr[next]) {
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

        if(!stack.isEmpty()) Write.write("NO");
        else {
            for(int i=0;i<(n*2);i++){
                Write.write(output[i]+"");
                Write.newLine();
            }
        }

        Write.newLine();
        Write.close();
        Read.close();
    }
}