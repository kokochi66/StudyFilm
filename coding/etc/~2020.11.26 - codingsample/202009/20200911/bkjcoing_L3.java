import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class bkjcoing_L3 {
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     for(int i=1;i<=9;i++){
    //         System.out.println(a + " * " + i + " = " + (a*i));
    //     }
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b;
    //     while(sc.hasNextInt()){
    //         a = sc.nextInt();
    //         b = sc.nextInt();
    //         System.out.println(a+b);
    //     }
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     System.out.println((a*(a+1))/2);
    // }
    //     public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     String[] temp = new String[2];
    //     for(int i=0;i<a;i++) {
    //         temp = bfr.readLine().split(" ");
    //         bfw.write((Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]))+"");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     for(int i=1;i<=a;i++) {
    //         bfw.write(i+"");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     for(int i=a;i>=1;i--) {
    //         bfw.write(i+"");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     String[] temp = new String[2];
    //     for(int i=1;i<=a;i++) {
    //         temp = bfr.readLine().split(" ");
    //         bfw.write("Case #"+i+": "+(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]))+"");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     String[] temp = new String[2];
    //     for(int i=1;i<=a;i++) {
    //         temp = bfr.readLine().split(" ");
    //         bfw.write("Case #"+i+": "+Integer.parseInt(temp[0])+" + "+Integer.parseInt(temp[1])+" = "+(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]))+"");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     for(int i=1;i<=a;i++) {
    //         for(int j=0;j<i;j++) bfw.write("*");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     int a = Integer.parseInt(bfr.readLine());
    //     for(int i=1;i<=a;i++) {
    //         for(int j=0;j<a-i;j++) bfw.write(" ");
    //         for(int j=0;j<i;j++) bfw.write("*");
    //         bfw.newLine();
    //     }
    //     bfw.flush();
    //     bfw.close();
    // }
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bfr.readLine().split(" ");
        String[] input2 = new String[Integer.parseInt(input[0])];
        input2 = bfr.readLine().split(" ");
        for(int i=0;i<input2.length;i++) {
            if(Integer.parseInt(input2[i]) < Integer.parseInt(input[1])) bfw.write(Integer.parseInt(input2[i])+" ");
        }
        bfw.flush();
        bfw.close();
    }
}
