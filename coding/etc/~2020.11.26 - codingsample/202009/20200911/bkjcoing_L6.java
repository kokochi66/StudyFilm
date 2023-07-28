import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class bkjcoing_L6 {
    private static void P1() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bfr.readLine());
        String[] input = bfr.readLine().split(" ");
        int[] inputint = new int[input.length];
        for(int i=0;i<inputint.length;i++) inputint[i] = Integer.parseInt(input[i]);
        System.out.print(IntStream.range(0, inputint.length).map(i->inputint[i]).min().getAsInt() + " ");
        System.out.print(IntStream.range(0, inputint.length).map(i->inputint[i]).max().getAsInt());
    }
    private static void P2() throws Exception {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt(), swit = 1, input;
        for(int i=1;i<9;i++) {
            input = sc.nextInt();
            if( max < input) {
                max = input;
                swit = i+1;
            }
        }
        System.out.println(max + " " + swit);
    }
    private static void P3() throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a *= sc.nextInt();
        a *= sc.nextInt();
        String input = a+"";
        int[] output = new int[10];
        Arrays.fill(output, 0);
        for(int i=0;i<input.length();i++) output[input.charAt(i)-'0']++;
        for(int i=0;i<10;i++) System.out.println(output[i]);
    }
    private static void P4() throws Exception {
        Scanner sc = new Scanner(System.in);
        int input;
        int[] output = new int[42];
        Arrays.fill(output,0);
        for(int i=0;i<10;i++) {
            input = sc.nextInt();
            output[input%42]++;
        }
        int count = 0;
        for(int i=0;i<42;i++) if(output[i] > 0) count++;
        System.out.println(count);
    }
    private static void P5() throws Exception {
        Scanner sc = new Scanner(System.in);
        int object = sc.nextInt();
        int[] score = new int[object];
        for(int i=0;i<object;i++) score[i] = sc.nextInt();
        int max = IntStream.range(0, object).map(i->score[i]).max().getAsInt();
        double sum = 0;
        for(int i=0;i<object;i++) {
            sum += (((double)score[i]/(double)max)*100.0);
        }
        System.out.println((double)(sum/object));
    }
    private static void P6() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int per = Integer.parseInt(bfr.readLine());
        String input;
        int output, score;
        boolean maru = false;
        for(int i=0;i<per;i++){
            output = 0;
            score = 1;
            input = bfr.readLine();
            for(int j=0;j<input.length();j++){
                if(input.charAt(j) == 'O') output += score++;
                else score = 1;
            }
            bfw.write(output+"");
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
    }
    private static void P7() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m;
        int[] stu = new int[1000];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = 0;
            m = sc.nextInt();
            for(int j=0;j<m;j++) stu[j] = sc.nextInt();
            double aver = (double)IntStream.range(0, m).map(q->stu[q]).sum()/(double)m;
            sum = IntStream.range(0, m).filter(w-> aver < stu[w]).map(w->stu[w]).toArray().length;
            System.out.printf("%.3f%%\n", (double)(IntStream.range(0, m).filter(w-> aver < stu[w]).map(w->stu[w]).toArray().length/(double)m)*100.0);
        }
    }
    public static void main(String[] args) throws Exception {
        // P1();
        // P2();
        // P3();
        // P4();
        // P5();
        // P6();
        P7();

    }
    
}
