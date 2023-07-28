import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KNU_week3_2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Boolean> boom = new ArrayList<Boolean>();
        int count = 0, swit = 0;
        String input = bfr.readLine();
        while(input != null){
            int n = Integer.parseInt(input.split(" ")[0]);
            int k = Integer.parseInt(input.split(" ")[1]);
            count = 0;
            swit = 0;
            boom.add(true);
            for(int i=0;i<n-1;i++) boom.add(false);
            while(n!=0){
                count++;
                swit = (swit+k)%n;
                n--;
                if(boom.get(swit)) break;
                boom.remove(swit);
            }
            if(n==0) System.out.println("win");
            else System.out.println(count);
            boom.clear();
            input = bfr.readLine();
        }
    }
}
