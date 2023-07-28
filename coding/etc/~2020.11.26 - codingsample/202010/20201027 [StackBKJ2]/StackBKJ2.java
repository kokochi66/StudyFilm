import java.io.*;
import java.util.*;

public class StackBKJ2 {
    // 1. https://www.acmicpc.net/problem/10799 쇠막대기
    // 2. https://www.acmicpc.net/problem/10773 제로
    // 3. https://www.acmicpc.net/problem/1406 에디터
    // 4. https://www.acmicpc.net/problem/4949 균형잡힌 세상
    // 5. https://www.acmicpc.net/problem/2504 괄호의 값

    public static void main(String[] args) throws Exception {
        // Solution();

    }
    

    public static void SortBKJ2_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        String input = Read.readLine();
        int Raser = 0;
        int output = 0;

        for(int i=0;i<input.length();i++){
            char Curr = input.charAt(i);
            if(Curr == '(' && i!=input.length()-1 && input.charAt(i+1) == ')') {
                Raser++;
                i +=1;
            } else if(Curr == '(') {
                stack.add(Raser);
            } else if(Curr == ')') {
                output += (Raser - stack.pop() +1);
            }
        }
        System.out.println(output);

    }   
    public static void SortBKJ2_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        String input = Read.readLine();
        int output = 0;
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            input = Read.readLine();
            int Curr = Integer.parseInt(input);
            if(Curr != 0) {
                stack.add(Curr);
            } else {
                stack.pop();
            }
        }
        while(!stack.isEmpty()) output += stack.pop();

        System.out.println(output);

    }   
    public static void SortBKJ2_3() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> Left = new Stack<Character>();
        Stack<Character> Right = new Stack<Character>();

        String input = Read.readLine();
        for(int i=0;i<input.length();i++) Left.add(input.charAt(i));

        input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            input = Read.readLine();

            if(input.equals("L") && !Left.isEmpty() ){
                Right.push(Left.pop());
            } else if(input.equals("D") && !Right.isEmpty()) {
                Left.push(Right.pop());
            } else if(input.equals("B") && !Left.isEmpty()) {
                Left.pop();
            } else if(input.charAt(0) == 'P') {
                char Curr = input.charAt(2);
                Left.push(Curr);
            }
        }
        while(!Left.isEmpty()) Right.push(Left.pop());
        while(!Right.isEmpty()) Write.write(""+Right.pop());
        Write.flush();
        Write.close();
        Read.close();

    }   
    public static void SortBKJ2_4() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean Fault = true;

        String input = Read.readLine();
        while(!input.equals(".")){
            if(SortBKJ2_4_func(input)) Write.write("yes");
            else Write.write("no");
            Write.newLine();
            input = Read.readLine();
        }
        Write.flush();
        Write.close();
        Read.close();

    }   
    public static boolean SortBKJ2_4_func(String s){
        if(s.length() == 0) return true;
        Stack<Integer> Big = new Stack<Integer>();
        Stack<Integer> Small = new Stack<Integer>();
        String temp;
        StringBuilder str = new StringBuilder(s);

        for(int i=0;i<str.length();i++){
            // System.out.println(str+"   "+str.charAt(i));
            if(str.charAt(i) == '('){
                Small.push(i);
            } else if (str.charAt(i) == ')') {
                if(Small.isEmpty()) return false; 
                else if (!Small.isEmpty()) {
                    temp = str.substring(Small.peek()+1, i);
                    if(!SortBKJ2_4_func(temp)) return false;
                    int sub = (i+1) - Small.peek();
                    str.delete(Small.pop(),i+1);
                    i-=sub;
                }
            } else if (str.charAt(i) == '[')  {
                Big.push(i);
            } else if (str.charAt(i) == ']')  {
                if(Big.isEmpty()) return false; 
                else if (!Big.isEmpty()) {
                    temp = str.substring(Big.peek()+1, i);
                    if(!SortBKJ2_4_func(temp)) return false;
                    int sub = (i+1) - Big.peek();
                    str.delete(Big.pop(),i+1);
                    // str.deleteCharAt(Big.pop());
                    // str.deleteCharAt(i-1);
                    i-=sub;
                }
            }
        }
        if(Big.isEmpty() && Small.isEmpty()) return true;
        else return false;
    }
    public static void SortBKJ2_5() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        String input = Read.readLine();
        if(input.isEmpty()) System.out.println(0);
        else {
            int output = SortBKJ2_5_func(input);
        if(output == -1) System.out.println(0);
        else System.out.println(output);
        }
        
    }
    public static int SortBKJ2_5_func(String s){
        if(s.length() == 0 ) return 1;
        Stack<Integer> Small = new Stack<Integer>();
        Stack<Integer> Big = new Stack<Integer>();

        StringBuilder str = new StringBuilder(s);
        int sum = 0;
        for(int i=0;i<str.length();i++){
            char Curr = str.charAt(i);
            // System.out.println(str +"   "+Curr+"   "+i);
            if(Curr == '(') {
                Small.push(i);
                int index = i+1;
                while(!Small.isEmpty()){
                    if(index >= str.length()) return -1;
                    Curr = str.charAt(index);
                    if(Curr == '(') Small.push(index);
                    else if(Curr == ')') {
                        if(Small.size() == 1) {
                            int thisVar = SortBKJ2_5_func(str.substring(Small.peek()+1, index));
                            if(thisVar == -1) return -1;
                            sum += 2*thisVar;
                            str.delete(Small.peek(), index+1);
                            i -= (i-Small.pop())+1;
                        } else Small.pop();
                    }
                    index++;
                }
            }
            else if(Curr == '['){
                Big.push(i);
                int index = i+1;
                while(!Big.isEmpty()){
                    if(index >= str.length()) return -1;
                    Curr = str.charAt(index);
                    if(Curr == '[') Big.push(index);
                    else if(Curr == ']') {
                        if(Big.size() == 1) {
                            int thisVar = SortBKJ2_5_func(str.substring(Big.peek()+1, index));
                            if(thisVar == -1) return -1;
                            sum += 3*thisVar;
                            str.delete(Big.peek(), index+1);
                            i -= (i-Big.pop())+1;
                        } else Big.pop();
                    }
                    index++;
                }

            }
        }
        if(Small.isEmpty() && Big.isEmpty() && str.toString().isEmpty()) return sum;
        else return -1;
    }

}
