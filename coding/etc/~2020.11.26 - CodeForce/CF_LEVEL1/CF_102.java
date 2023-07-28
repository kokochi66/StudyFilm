package CodeForce.CF_LEVEL1;

import java.io.*;

public class CF_102 {
        static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(Read.readLine());
        int count = 0;
        for(int i=1;i<=n;i++){
            if(Euclidean_GL(n,i)==1) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int Euclidean_GL(int a, int b) throws Exception {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int res = 0;
        while(min>0){
            int pset = max/min;
            int nset = max%min;
            if(nset == 0){
                res = min;
                break;
            }
            max = min;
            min = nset;
        }
        // 최소공배수 = (a*b)/res
        // 최대공약수 = res
        return res;
    }
    
}
