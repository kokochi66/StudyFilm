import java.io.*;
import java.util.stream.IntStream;

public class bkjcoing_L8_1 {
    private static void P1() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        bfw.write((int)bfr.readLine().charAt(0)+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }

    private static void P2() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        input = bfr.readLine();
        String[] inputToken = input.split("");
        bfw.write(IntStream.range(0, inputToken.length).map(i->inputToken[i].charAt(0)-'0').sum()+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P3() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int[] output = new int[26];
        for(int i = 0;i<26;i++){
            bfw.write(input.indexOf(i+'a')+" ");
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P4() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        String[] inputToken;
        for(int i = 0; i < n ; i++){
            inputToken = bfr.readLine().split(" ");
            int m = Integer.parseInt(inputToken[0]);
            for(int j=0 ; j<inputToken[1].length();j++) {
                for(int k=0;k<m;k++) bfw.write(inputToken[1].charAt(j));
            }
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P5() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int maxTemp = 0, maxCount = 0, outTemp=0, var;
        int[] outputTemp = new int[26];
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) > 'Z') var = input.charAt(i)-'a';
            else var = input.charAt(i)-'A';
            outputTemp[var]++;
            if(maxTemp <  outputTemp[var]) maxTemp =  outputTemp[var];
        }
        for(int i=0;i<outputTemp.length;i++) {
            if(maxTemp==outputTemp[i]) {
                maxCount++;
                outTemp = i;
            }
        }
        if(maxCount>1) bfw.write("?");
        else bfw.write((char)(outTemp+'A'));
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P6() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        input = input.trim();
        String[] inputToken = input.split(" ");
        if(input.isEmpty()) bfw.write(0+"");
        else bfw.write(inputToken.length+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P7() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String[] inputToken = input.split(" ");
        inputToken[0] = new StringBuilder(inputToken[0]).reverse().toString();
        inputToken[1] = new StringBuilder(inputToken[1]).reverse().toString();
        int a = Integer.parseInt(inputToken[0]);
        int b = Integer.parseInt(inputToken[1]);
        bfw.write(Math.max(a,b)+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    private static void P8() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int sum = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>='A'&&input.charAt(i)<='C') sum += 3;
            else if(input.charAt(i)>='D'&&input.charAt(i)<='F') sum += 4;
            else if(input.charAt(i)>='G'&&input.charAt(i)<='I') sum += 5;
            else if(input.charAt(i)>='J'&&input.charAt(i)<='L') sum += 6;
            else if(input.charAt(i)>='M'&&input.charAt(i)<='O') sum += 7;
            else if(input.charAt(i)>='P'&&input.charAt(i)<='S') sum += 8;
            else if(input.charAt(i)>='T'&&input.charAt(i)<='V') sum += 9;
            else if(input.charAt(i)>='W'&&input.charAt(i)<='Z') sum += 10;
        }
        bfw.write(sum+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void main(String[] args) throws Exception {
        P8();
    }
    
}
