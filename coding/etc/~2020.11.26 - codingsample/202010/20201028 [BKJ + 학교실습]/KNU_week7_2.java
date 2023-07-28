import java.util.*;
import java.io.*;
public class KNU_week7_2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = sc.nextLine();
        StringBuilder Original = new StringBuilder(input);
        while(sc.hasNext()){
            input = sc.nextLine();
            int n = Integer.parseInt(input);
            StringBuilder temp = new StringBuilder(Original);
            for(int i=0;i<n-1;i++){
                StringBuilder tempNext = new StringBuilder("");

                int Curr = -1;
                int CurrCount = 0;
                for(int j=0;j<=temp.length();j++){
                    if(j<temp.length() && j != 0 && (temp.charAt(j)-'0') != Curr) {
                        tempNext.append(Curr+""+CurrCount);
                        CurrCount = 0;
                    } else if (j==temp.length()){
                        tempNext.append(Curr+""+CurrCount);
                    } 
                    if(j<temp.length()){
                        Curr = temp.charAt(j) -'0';
                        CurrCount++;
                    }
                }
                temp = tempNext;
            }
            System.out.println(temp);
        }
    }
}
