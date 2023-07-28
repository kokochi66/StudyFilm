import java.io.*;
import java.util.ArrayList;

public class KNU_week3_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String[] inputToken;
        int test = Integer.parseInt(input);
        int countP, LostCount, halfP;
        ArrayList<Integer> Pscore = new ArrayList<Integer>();
        String[] week = {"Sun","Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        ArrayList<String> output = new ArrayList<String>();
        for(int testCase = 0; testCase < test ; testCase++) {
            if(testCase>=1) bfw.newLine();
            LostCount = 0;
            output.clear();
            Pscore.clear();
            input = bfr.readLine();
            int n = Integer.parseInt(input);
            input = bfr.readLine();
            int p = Integer.parseInt(input);
            if(p%2==0) halfP = p/2;
            else halfP = (p/2)+1;
            for(int numP = 0; numP < p; numP++) Pscore.add(Integer.parseInt(bfr.readLine()));
            for(int i=1;i<=n;i++){
                countP = 0;
                for(int j=0;j<p;j++) if(i%Pscore.get(j) == 0) countP++;     //동의한 정당의 수를 체크
                if(countP >= halfP && !((i-1)%7 == 0 || (i-1)%7 == 3 || (i-1)%7 == 6)) {
                    output.add(week[(i-1)%7] + ": " + i);
                    LostCount++;
                }
            }
            bfw.write("Lost: " + LostCount);
            bfw.newLine();
            for(int i=0;i<output.size();i++){
                bfw.write(output.get(i));
                bfw.newLine();
            }
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    
}
