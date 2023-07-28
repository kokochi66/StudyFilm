package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1110 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        int n = Integer.parseInt(rd.readLine());
        int[] arr = new int[n];
        tok = new StringTokenizer(rd.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int k = Integer.parseInt(rd.readLine());
        int p = n / k;
//        System.out.println("p = " + p);

        for(int i=0;i<k;i++) {
            int left = i * p;
            Arrays.sort(arr, left, left + p);
        }
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
