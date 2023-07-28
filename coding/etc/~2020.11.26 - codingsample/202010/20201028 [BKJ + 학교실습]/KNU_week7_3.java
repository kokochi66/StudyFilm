import java.util.*;
import java.io.*;
public class KNU_week7_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        ArrayList<Integer> pib = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            pib.add(1);
            pib.add(2);
            input = Read.readLine();
            int Curr = Integer.parseInt(input);

            int index = 0;
            while(pib.get(pib.size()-1) < Curr) {
                pib.add(pib.get(index)+pib.get(index+1));
                index++;
            }
            int Point = 0;
            index = pib.size()-1;
            ArrayList<Integer> Sum = new ArrayList<Integer>();
            while(Point != Curr){
                if(Point + pib.get(index) <= Curr){
                    Sum.add(pib.get(index));
                    Point += pib.get(index);
                    index--;
                }
                index--;
            }
            for(int q=0;q<Sum.size();q++) {
                System.out.print(Sum.get(q)+"");
                if(q!=Sum.size()-1) System.out.print(" ");
            }
            System.out.println();
        }

        Write.flush();
        Write.close();
        Read.close();
    }
}
