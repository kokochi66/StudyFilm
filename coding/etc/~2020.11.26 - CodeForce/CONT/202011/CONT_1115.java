import java.util.*;
import java.io.*;
 
public class CONT_1115 {
    static final int INTMAX = Integer.MAX_VALUE;
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        n = Integer.parseInt(Read.readLine());
        arr = new int[n];
        int bit = 1<<30;
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int temp;
        for(int i=1;i<n;i++){
            int c=i,root;
            do {
                root = (c-1)/2;
                if(arr[root] < arr[c]){
                    temp=arr[root];
                    arr[root]=arr[c];
                    arr[c]=temp;
                }
                c=root;
            } while(c!=0);
        }
        while(bit > 0 && (bit&arr[0])==0) bit/=2;
        for(int i=n-1;i>=0;i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int c=0,next;
            do{
                next=(c*2)+1;
                if(next+1<i&&arr[next]<arr[next+1])next++;
                if(next<i&&arr[c]<arr[next]){
                    temp=arr[c];
                    arr[c]=arr[next];
                    arr[next]=temp;
                }
                c=next;
            }while(c<i);
        }
        int res = CONT_1115_5_rec(0,n-1,bit);
        System.out.println(n-res);
    }
    public static int CONT_1115_5_rec(int si, int ei, int bits) {
        if(ei-si <= 0) return 1;
        int j = ei-1;
        while(j>=si && (arr[j]&bits)!=0) j--;
        // System.out.println(j+" j");
        if(j<si){
            for(int i=si;i<=ei;i++){
                arr[i] -= bits;
            }
            int cb = bits/2;
            while(cb>0 && (arr[ei]&cb)==0)  cb/=2;
            int eq = CONT_1115_5_rec(si,ei,cb);
            // System.out.println(eq+" eqcb "+cb);
            return eq;
        } else {
            int cb = bits/2;
            while(cb>0 && (arr[j]&cb)==0) cb/=2;
            return 1+Math.max(CONT_1115_5_rec(si,j,cb),CONT_1115_5_rec(j+1,ei,bits));
        }
    }
    public static void CONT_1115_4 () throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        char[] arr1 = Read.readLine().toCharArray();
        char[] arr2 = Read.readLine().toCharArray();
        char[][] darr = new char[n+1][m+1];
        int max = -1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]) darr[i][j] = (char)(darr[i-1][j-1]+1);
                else darr[i][j] = (char)Math.max(darr[i-1][j],darr[i][j-1]);
                if(max < (int)darr[i][j]) {
                    max = (int)darr[i][j];
                }
            }
        }
        
        for(int i=0;i<darr.length;i++){
            for(int j=0;j<darr[0].length;j++){
                System.out.print((int)darr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void CONT_1115_3() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());
            long w = Long.parseLong(tok.nextToken());
            long half = w/2;
            if(w%2!=0) half++;
            // 선언 및 입력부
            darr = new int[n][2];
            tok = new StringTokenizer(Read.readLine());
            for(int i=0;i<n;i++){
                darr[i][0] = Integer.parseInt(tok.nextToken());
                darr[i][1] = i+1;
            }
            int[] temp = new int[2];
            for(int i=1;i<n;i++){
                int c=i, root;
                do{
                    root = (c-1)/2;
                    if(darr[root][0] < darr[c][0]){
                        temp = darr[root];
                        darr[root]=darr[c];
                        darr[c]=temp;
                    }
                    c=root;
                }while(c!=0);
            }
            long sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            boolean res = false;
            for(int i=n-1;i>=0;i--){
                sum += darr[0][0];
                list.add(darr[0][1]);
                if(sum>=half && sum<=w) {
                    res = true;
                    break;
                } else if(sum>half){
                    sum -= darr[0][0];
                    list.remove(list.size()-1);
                }
                darr[0] = darr[i];
                int c=0, next;
                do {
                    next = (c*2)+1;
                    if(next+1<i && darr[next][0] < darr[next+1][0]){
                        next++;
                    }
                    if(next<i && darr[next][0] > darr[c][0]){
                        temp = darr[c];
                        darr[c]=darr[next];
                        darr[next]=temp;
                    }
                    c=next;
                } while(c<i);
            }
            if(res){
                Write.write(list.size()+"");
                Write.newLine();
                for(int i=0;i<list.size();i++) Write.write(list.get(i)+" ");
            } else {
                Write.write("-1");
            }
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1115_2() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int tt=0;tt<TestCase;tt++){
            tok = new StringTokenizer(Read.readLine());
            h = Integer.parseInt(tok.nextToken());
            w = Integer.parseInt(tok.nextToken());
            arr = new int[h*w];
            int CM = 0, sum=0;
            for(int i=0;i<h;i++){
                tok = new StringTokenizer(Read.readLine());
                for(int j=0;j<w;j++) {
                    arr[(w*i)+j] = Integer.parseInt(tok.nextToken());
                    if(arr[(w*i)+j]<0) {
                        arr[(w*i)+j] = -arr[(w*i)+j];
                        CM++;
                    }
                }
            }
            CM%=2;
            Arrays.sort(arr);
            for(int i=0;i<CM;i++) arr[i] = -arr[i];
            for(int i=0;i<h*w;i++) {
                sum += arr[i];
            }
            Write.write(sum+"");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1115_1() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int tt=0;tt<TestCase;tt++){
            n = Integer.parseInt(Read.readLine());
            Write.write(n+"");
            Write.newLine();
            for(int i=1;i<=n;i++) Write.write(i+" ");
            Write.newLine();
        }
        Write.flush();
    }
    
}
