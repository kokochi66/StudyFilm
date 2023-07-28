import java.io.*;
import java.util.Arrays;

public class bkjcoing_L8_2 {
    public static void P9() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int count = input.length();
        for(int i=1;i<input.length();i++){
            if(input.charAt(i) == '=') {
                if(input.charAt(i-1) == 'c' || input.charAt(i-1) == 's') count--;
                else if(input.charAt(i-1) == 'z') {
                    if(i>1 && input.charAt(i-2) == 'd') count-=2;
                    else count--;
                }

            }
            else if(input.charAt(i) == '-') count--;
            else if(input.charAt(i) == 'j') {
                if(input.charAt(i-1) == 'l' || input.charAt(i-1) == 'n') count--;
            }
        }
        bfw.write(count+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P10() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] alpha = new boolean[26];
        int count = 0;
        String input = bfr.readLine();
        int n = Integer.parseInt(input);
        for(int i = 0;i<n;i++){
            input = bfr.readLine();
            Arrays.fill(alpha, false);
            if(input.length() == 1) count++;
            for(int j=1;j<input.length();j++){
                if(alpha[input.charAt(j) - 'a']) break;
                if(input.charAt(j) != input.charAt(j-1)) alpha[input.charAt(j-1) - 'a'] = true;
                if(j == input.length()-1) count++;
            }
        }
        bfw.write(count+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void main(String[] args) throws Exception {
        P10();
    }
}
