import java.util.Scanner;
import java.util.Stack;

public class Stack_StackTest {
    //캔을 순서대로 쌓고, *이 들어오면 맨 위에있는 캔을 버리고, 캔쌓기가 끝나면 맨 위캔부터 출력함.
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<String>();
        String input;
        while(sc.hasNext()){
            input = sc.nextLine();
            String[] inputToken = input.split(" ");
            for(int i=0;i<inputToken.length;i++){
                if(!inputToken[i].equals("*")) st.push(inputToken[i]);
                else if(inputToken[i].equals("*") && !st.isEmpty()) st.pop();
            }
            while(!st.isEmpty()){
                System.out.print(st.pop() + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
