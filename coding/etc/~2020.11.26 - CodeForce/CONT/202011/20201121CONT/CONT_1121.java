import java.util.*;
import java.io.*;

public class CONT_1121 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static int[] oper;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            long n = Long.parseLong(tok.nextToken());
            long m = Long.parseLong(tok.nextToken());
            // Insert O

            boolean pass = false;
            long mp=0, np=n*n;
            while((mp*mp)+(mp*mp)<np) {
                mp += m;
            }
            mp -= m;
            // Write.write(mp+"");
            // Write.newLine();
            if((mp*mp)+((mp+m)*(mp+m))<=np) Write.write("Ashish");
            else Write.write("Utkarsh");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1121_3() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int k = Integer.parseInt(tok.nextToken());
            StringBuilder A = new StringBuilder(Read.readLine());
            StringBuilder B = new StringBuilder(Read.readLine());
            // INSERT O
            int[] Aoper = new int[27];
            int[] Boper = new int[27];
            for(int i=0;i<n;i++){
                Aoper[A.charAt(i)-'a']++;
                Boper[B.charAt(i)-'a']++;
            }


            boolean pass = false;
            for(int i=0;i<26;i++){
                if(i>0){
                    Aoper[i] += Aoper[i-1];
                    Boper[i] += Boper[i-1];
                }
                if(Boper[i] > Aoper[i] || (Aoper[i]-Boper[i])%k!=0){
                    pass = true;
                    break;
                }
            }
            // System.out.println(Arrays.toString(Aoper));
            // System.out.println(Arrays.toString(Boper));
            // System.out.println(pass);

            if(pass) Write.write("NO");
            else Write.write("YES");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1121_2() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());
            StringBuilder str = new StringBuilder(Read.readLine());
            int[] fst = new int[2];
            int[] lst = new int[2];
            for(int i=0;i<2;i++) fst[i] = -1;
            for(int i=0;i<str.length();i++){
                if(fst[str.charAt(i)-'0']==-1) fst[str.charAt(i)-'0'] = i;
                lst[str.charAt(i)-'0'] = i;
            }
            for(int TS=0;TS<m;TS++){
                tok = new StringTokenizer(Read.readLine());
                int left =Integer.parseInt(tok.nextToken())-1;
                int right =Integer.parseInt(tok.nextToken())-1;
                // Insert O

                boolean pass = false;
                int lc = str.charAt(left)-'0';
                int rc = str.charAt(right)-'0';
                if(fst[lc] < left || lst[rc] > right) pass = true;

                if(pass) Write.write("YES");
                else Write.write("NO");
                Write.newLine();
            }
        }
        Write.flush();
    }
    public static boolean CONT_1121_2_dfs(int m, int k, StringBuilder str, StringBuilder substr, int ci) {
        // System.out.println(str.length()-(m-k) +"  전체길이");
        if(k == m) {
            // System.out.println(Arrays.toString(oper));
            int sum = 0;
            for(int i=0;i<m-1;i++){
                sum += oper[i+1] - oper[i];
            }
            return sum != (m-1);
        }
        for(int i=ci;i<=str.length()-(m-k);i++){
            if(substr.charAt(k) == str.charAt(i)) {
                oper[k] = i;
                if(CONT_1121_2_dfs(m,k+1,str,substr,i+1)) return true;
            }
        }
        return false;
    }
    public static void CONT_1121_1() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            int n = Integer.parseInt(Read.readLine());
            // Insert O
            int count = 0;
            while(n!=1){
                count++;
                int gcd = 0;
                for(int i=2;i<=Math.sqrt(n);i++){
                    if(n%i==0) {
                        gcd = n/i;
                        break;
                    }
                }
                if(gcd==0 && n>1) n--;
                else n/=gcd;
            }
            Write.write(Math.min(3,count)+"");
            Write.newLine();
        }
        Write.flush();
    }
}