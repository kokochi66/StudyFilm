import java.io.*;
import java.util.Arrays;
import java.util.stream.LongStream;

public class bkjcoing_L7 {

    public static long P1(int[] a) {
            return LongStream.range(0, a.length).map(i->a[(int)i]).sum();
    }
    public static void P2() throws Exception {
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        Boolean[] check = new Boolean[10001];
        Arrays.fill(check,false);
        int temp, sum;
        for(int i = 1;i<=10000; i ++) {
            temp = i;
            sum = i;
            while(temp != 0){
                sum += temp%10;
                temp /= 10;
            }
            if(sum<=10000) check[sum] = true;
            if(!check[i]) {
                bfw.write(i+"");
                bfw.newLine();
            }
        }
        bfw.flush();
        bfw.close();
    }

    public static void P3() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        int count = 0, diff, temp;
        boolean check = false;
        for(int i =1 ; i <= n ; i++){
            check = true;
            temp = i;
            diff = ((i/10)%10) - (i%10);
            while(temp/10 != 0) {
                if(((temp/10)%10) - (temp%10) != diff) {
                    check = false;
                    break;
                }
                temp /= 10;
            }
            if(check) count++;
        }
        bfw.write(count+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void main(String[] args) throws Exception{
        // int[] a = {1,2,3,4,5};
        // System.out.println(P1(a));
        // P2();
        P3();
    }
    
}
