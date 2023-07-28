import java.io.*;
import java.util.Arrays;

public class KNU_week4_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input1 = bfr.readLine();
        String input2 = bfr.readLine();
        int[] temp1 = new int[26];
        int[] temp2 = new int[26];
        Arrays.fill(temp1,0);
        Arrays.fill(temp2,0);
        for(int i=0;i<Math.max(input1.length(),input2.length());i++){
            if(i<input1.length()) temp1[input1.charAt(i)-'a']++;
            if(i<input2.length()) temp2[input2.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            count += Math.max(temp1[i],temp2[i]) - Math.min(temp1[i],temp2[i]);
        }
        bfw.write(count+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    
}
