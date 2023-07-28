import java.io.*;
import java.util.*;

public class StackBKJ4_1 {
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder iS = new StringBuilder(Read.readLine());
        char[] bA = Read.readLine().toCharArray();
        int bS = bA.length-1;
        char[] stack = new char[1000001];
        int sS = 0;

        for(int i=0;i<iS.length();i++){
            if(iS.charAt(i) != bA[bS]) {
                stack[sS] = iS.charAt(i);
                sS++;
            }
            else {
                int index = 1;
                while(sS>=index && bS>=index && stack[sS-index] == bA[bS-index]){
                    index++;
                }
                if(index == bA.length) {
                    sS -= (index-1);
                } else {
                    stack[sS] = iS.charAt(i);
                    sS++;
                }
            }
        }
        String output = String.valueOf(stack,0,sS);
        if(output.length() == 0) System.out.println("FRULA");
        else System.out.println(output);
        Read.close();
    }

    public static void StackBKJ4_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer[]> tower = new Stack<Integer[]>();
        String input = Read.readLine();
        
        while(!input.equals("0")){
            long max = 0;
            String[] tok = input.split(" ");

            for(int i=1;i<tok.length;i++){
                int tId = i;
                int n = Integer.parseInt(tok[i]);


                while(!tower.isEmpty() && n < tower.peek()[0]) {
                    long tempMax = (long)(i-tower.peek()[1]) *tower.peek()[0];
                    max = max > tempMax ? max : tempMax;
                    tId = tower.peek()[1];
                    tower.pop();
                }
                tower.push(new Integer[]{n,tId});
            }

            while(!tower.isEmpty()){
                long tempMax = (long)(tok.length-tower.peek()[1]) *tower.peek()[0];
                max = max > tempMax ? max : tempMax;
                tower.pop();
            }

            Write.write(max+"");
            Write.newLine();

            input = Read.readLine();
        }
        Write.flush();
        Write.close();
        Read.close();
    }   

}