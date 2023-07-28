import java.io.*;
import java.util.Scanner;


public class bkjcoing_L4 {
    // public static void main(String[] args) throws Exception {
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = 1, b = 1;
    //     boolean start = false;
    //     String[] input = new String[2];
    //     do {
    //         if(start) {
    //             bfw.write((a+b)+"");
    //             bfw.newLine();
    //         }
    //         else start = true;
    //         input = bfr.readLine().split(" ");
    //         a = Integer.parseInt(input[0]);
    //         b = Integer.parseInt(input[1]);
    //     } while(a!=0&&b!=0);
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception {
    //     Scanner sc = new Scanner(System.in);
    //     int a,b;
    //     while(sc.hasNextInt()){
    //         a = sc.nextInt(); 
    //         b = sc.nextInt();
    //         System.out.println(a+b);
    //     }
    // }
    private static int Cycle(int a, int b, int cycle){
        if(a == 0) return 1;
        if(a == b) return cycle;
        if(b==0) b = a;
        return Cycle(a,((b%10)*10) + (((b/10)%10)+(b%10))%10,cycle+1);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a<10) a *= 10;
        System.out.println(Cycle(a,0,0));
    }
}
