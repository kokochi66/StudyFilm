import java.io.*;
import java.util.*;

public class BKJ {
    public static void main(String[] args) throws Exception {
        Solution();
    }

    public static void Solution() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=0;i<n;i++){
            input = Read.readLine();
            int Curr = Integer.parseInt(input);
            if(Curr == 0) Write.write(1 +" "+0);
            else {
                int[][] temp = new int[Curr+1][2];
                temp[0] = new int[]{1,0};
                temp[1] = new int[]{0,1};
                int index = 2;

                while(index<Curr+1){
                    temp[index] = new int[]{temp[index-1][0]+temp[index-2][0] , temp[index-1][1] + temp[index-2][1]};
                    index++;
                }
                Write.write(temp[Curr][0] +" "+temp[Curr][1]);
            }
            Write.newLine();
            
        }
        Write.flush();
        Write.close();
        Read.close();

    }

}
