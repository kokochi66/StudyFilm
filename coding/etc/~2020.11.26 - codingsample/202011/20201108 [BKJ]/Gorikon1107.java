import java.io.*;
import java.util.*;

public class Gorikon1107 {

    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder output = new StringBuilder("");
    static StringTokenizer tok;
    static int h, w, count;
    static int[][] arr;
    static int[][] used;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Gorikon1107_G() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        arr = new int[h][w];
        used = new int[h][w];
        for(int i=0;i<h;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<w;j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        count = 0;
        Gorikon1107_G_FUNC(0,0,arr[0][0]);
        Write.write(count+"");
        Write.newLine();
        for(int i=0;i<count;i++){
            Write.write(output.substring(output.length()-4,output.length()));
            output.delete(output.length()-4,output.length());
            Write.newLine();
        }
        Write.flush();
    }
    public static boolean Gorikon1107_G_FUNC(int hi, int wi, int weight) throws Exception {
        count++;
        used[hi][wi]++;
        if(hi == h-1 && wi == w-1 && weight == 0) {
            output.append(hi+" "+wi+" ");
            return true;
        }
        else if(hi == h-1 && wi == w-1 && weight != 0) {
            used[hi][wi]--;
            count--;
            return false;
        }
        if(wi<w-1 && used[hi][wi+1]<2) {
            if(Gorikon1107_G_FUNC(hi,wi+1,weight^arr[hi][wi+1])) {
                output.append(hi+" "+wi+" ");
                return true;
            }
        }
        if(hi<h-1 && used[hi+1][wi]<2) {
            if(Gorikon1107_G_FUNC(hi+1,wi,weight^arr[hi+1][wi])) {
                output.append(hi+" "+wi+" ");
                return true;
            }
        }
        if(hi>0 && used[hi-1][wi]<2) {
            if(Gorikon1107_G_FUNC(hi-1,wi,weight^arr[hi-1][wi])) {
                output.append(hi+" "+wi+" ");
                return true;
            }
        }
        if(wi>0 && used[hi][wi-1]<2) {
            if(Gorikon1107_G_FUNC(hi,wi-1,weight^arr[hi][wi-1])) {
                output.append(hi+" "+wi+" ");
                return true;
            }
        }
        used[hi][wi]--;
        count--;
        return false;
    }
    public static void Gorikon1107_F() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int[] arr = new int [n+5];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());

        int temp;
        for(int i=1;i<n;i++){
            int c=i, root;
            do {
                root = (c-1)/2;
                if(arr[root] > arr[c]){
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }

        for(int i=n-1;i>=0;i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int c=0,next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next] > arr[next+1]) next++;
                if(next<i && arr[next] < arr[c]){
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

        int left = 0, right = n-1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<n;i++) list.add(arr[i]);
        int res = 0;
        while(!list.isEmpty()){
            int ta = list.remove(0);
            if(list.size()>=1) {
                list.remove(list.size()-1);
                res += (ta*2);
            }
            else res += ta;
        }
        System.out.println(res);
    }
    public static void Gorikon1107_E() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int L = Integer.parseInt(tok.nextToken());
        tok = new StringTokenizer(Read.readLine());
        boolean pass = false;

        long[] arr = new long[n+5];
        long[] sum = new long[n+5];

        for(int i=1;i<=n;i++){
            arr[i] = Long.parseLong(tok.nextToken());
        }
        arr[n+1] = 0;

        for(int i=n;i>=2;i--){
            sum[i] = (long)sum[i+1] + (long)arr[i];
            long Curr = (long)((sum[i])*(long)10)/(long)((long)(n-i+1));
            long Curx = (long)(arr[i-1]+L)*(long)10;
            long Cury = (long)(arr[i-1]-L)*(long)10;
            // System.out.println(sum[i] +"/"+(n-i+1)+"   "+ Curr +"   "+Curx+"  "+Cury);
            if(!(Cury < Curr && Curx > Curr)){
                pass = true;
                break;
            }
        }
        if(pass) System.out.println("unstable");
        else  System.out.println("stable");

    }
    public static void Gorikon1107_D() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        double[] arr = new double[n+5];
        tok = new StringTokenizer(Read.readLine()); 
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());

        double temp;
        for(int i=1;i<n;i++){
            int c=i, root;
            do {
                root = (c-1)/2;
                if(arr[root] >  arr[c]){
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }
        for(int i=n-1;i>=0;i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int c=0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next] > arr[next+1]) next++;
                if(next<i && arr[next] < arr[c]){
                    temp = arr[next];
                    arr[next] = arr[c];
                    arr[c] = temp;
                }
                c = next;
            } while(c<i);
        }

        double res = arr[0];
        for(int i=1;i<n;i++){
            res += arr[i]/(double)2;
        }
        System.out.println(res);
    }
    public static void Gorikon1107_C() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int h = Integer.parseInt(tok.nextToken());
        int w = Integer.parseInt(tok.nextToken());
        boolean pass = false;

        char[][] arr = new char[h][n*w];
        for(int i=0;i<h;i++){
            arr[i] = Read.readLine().toCharArray();
        }
        for(int i=0;i<n;i++){
            pass = false;
            int Currx = w*i;
            for(int wpp=Currx;wpp<Currx+w;wpp++){
                for(int hpp=0;hpp<h;hpp++){
                    if(arr[hpp][wpp] != '?') {
                        output.append(arr[hpp][wpp]);
                        pass = true;
                        break;
                    }
                }
                if(pass) break;
            }
            if(!pass) output.append('?');

        }
        System.out.println(output);
    }
    public static void Gorikon1107_B() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        tok = new StringTokenizer(Read.readLine());
        int[] arr = new int[n+5];
        boolean dupli = false;
        for(int i=1;i<=n;i++) arr[Integer.parseInt(tok.nextToken())]++;

        int[] max = new int[2];
        max[0] = 0;
        max[1] = 0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > max[0]) {
                dupli = false;
                max[0] = arr[i];
                max[1] = i;
            }
            else if(arr[i] == max[0]){
                dupli = true;
            }
        }
        if(dupli) System.out.println("skipped");
        else System.out.println(max[1]);
    }
    public static void Gorikon1107_A() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        char[][] arr = new char[n+5][n+5];
        for(int i=0;i<n;i++){
            arr[i] = Read.readLine().toCharArray();
        }
        for(int i=0;i<n;i++){
            StringBuilder a = new StringBuilder("");
            StringBuilder b = new StringBuilder("");
            a.append(arr[i]);
            for(int j=0;j<n;j++) b.append(arr[j][i]);
            if(a.compareTo(b) != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
