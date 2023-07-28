import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BKJ1108 {

    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static int[] arr;
    static int h, w;
    public static void main(String[] args) throws Exception {
        Solution();
    }

    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int AN = 1 << n;
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        arr = new int[4];
        arr[0] = 0;
        BKJ1108_DQ_FUNC(AN,0,0,n,0);
        // for(int i=0;i<AN;i++) System.out.println(Arrays.toString(darr[i]));
        Write.flush();
    }
    public static void BKJ1108_DQ_FUNC(int size, int hc, int wc, int n, int root) throws Exception {
        if(size == 2){
            arr[0] = root;
            arr[1] = root+1;
            arr[2] = root+2;
            arr[3] = root+3;
            int ht = h-hc;
            int wt = w-wc;
            int swit = ht==0 ? (wt==0 ? 0 : 1) : wt==0 ? 2 : 3;
            Write.write(arr[swit]+"");
            return;
        }
        int weight = (1<<((n-1)*2));
        arr[1] = (root) + weight;
        arr[2] = (root) + (weight*2);
        arr[3] = (root) + (weight*3);
        if(h<hc+(size/2) && w<wc+(size/2)) BKJ1108_DQ_FUNC(size/2, hc, wc, n-1, root);
        else if(h<hc+(size/2) && w>=wc+(size/2)) BKJ1108_DQ_FUNC(size/2, hc, wc+(size/2), n-1, arr[1]);
        else if(h>=hc+(size/2) && w<wc+(size/2)) BKJ1108_DQ_FUNC(size/2, hc+(size/2), wc, n-1, arr[2]);
        else if(h>=hc+(size/2) && w>=wc+(size/2)) BKJ1108_DQ_FUNC(size/2, hc+(size/2), wc+(size/2), n-1, arr[3]);
    }
}