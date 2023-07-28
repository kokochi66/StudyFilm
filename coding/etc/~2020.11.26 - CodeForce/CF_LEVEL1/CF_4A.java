package CodeForce.CF_LEVEL1;

import java.io.*;

public class CF_4A {
        static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(Read.readLine());
        int a = 1;
        boolean pass = false;
        while(a<n){
            if(a%2==0 && (n-a)%2==0){
                Write.write("YES");
                pass = true;
                break;
            }
            a++;
        }
        if(!pass) Write.write("NO");
        Write.flush();
    }
    
}
