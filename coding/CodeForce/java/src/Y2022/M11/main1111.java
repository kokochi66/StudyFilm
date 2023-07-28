package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main1111 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        long k = Long.parseLong(rd.readLine());
        int res = dc(k, 0);
        System.out.println(res);

    }

    public static int dc(long k, int count) {
//        System.out.println(k +" " + count);
        if(k == 1L) return count % 2 == 0 ? 0 : 1;
        long n = 2;
        while(n < k) n *= 2;
        long mid = (n / 2);
        return dc(k - mid, count + 1);
    }

    // 0 1 10 1001 10010110 1001011001101001
}
