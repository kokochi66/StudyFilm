import java.io.*;
import java.util.*;

public class Recur1031 {
    // 1. https://www.acmicpc.net/problem/10870 피보나치 재귀
    // 2. https://www.acmicpc.net/problem/2447 별 찍기

    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        Solution();
    }
    public static void Solution() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        Write.write((int)(Math.pow(2,n)-1)+"");
        Write.newLine();
        Recur1031_3_func(n,1,2,3);
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void Recur1031_3_func(int n, int f, int b, int t) throws Exception{
        if(n==1) {
            Write.write(f+" "+t);
            Write.newLine();
        }
        else {
            Recur1031_3_func(n-1,f,t,b);
            Write.write(f+" "+t);
            Write.newLine();
            Recur1031_3_func(n-1,b,f,t);
        }
    }

    public static void Recur1031_1() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);


        int[] arr = new int[n+1];
        arr[0] = 0;
        if(n>=1) arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        Write.write(arr[n]+"");


        Write.flush();
        Write.close();
        Read.close();
    }
    public static void Recur1031_2() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);

        String[] star = new String[n];
        String[] b = {"***","* *","***"};
        ArrayList<String[]> save = new ArrayList<String[]>();
        save.add(b);
        int index = 3;

        while(index < n){
            index *= 3;
            String[] temp = new String[index];
            char[] blank = new char[index/3];
            Arrays.fill(temp,"");
            Arrays.fill(blank,' ');
            for(int i=0;i<index;i++){
                temp[i] += save.get(save.size()-1)[i%(index/3)];
                if(i>= index/3 && i< (index/3)*2){
                    temp[i] += new String(blank);
                } else temp[i] += save.get(save.size()-1)[i%(index/3)];
                temp[i] += save.get(save.size()-1)[i%(index/3)];
            }
            save.add(temp);

        }
        for(int i=0;i<n;i++){
            Write.write(save.get(save.size()-1)[i]);
            Write.newLine();
        }

        Write.flush();
        Write.close();
        Read.close();
    }


}
