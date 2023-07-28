import java.io.*;
import java.util.Scanner;
import java.util.stream.IntStream;

public class bkjcoing_L5 {
    private static int P1(int[] score){
        return IntStream.range(0, score.length).map(i->score[i]).sum()/score.length;
    }
    private static int P2(int[] price){
        return IntStream.range(0, 3).map(i->price[i]).min().getAsInt() + IntStream.range(3, 5).map(i->price[i]).min().getAsInt() - 50;
    }
    private static int P3(int[] arr){
        int max = IntStream.range(0, arr.length).map(j->arr[j]).max().getAsInt();
        if(IntStream.range(0,arr.length).filter(i->max>arr[i]).toArray().length < 2) return max;
        return IntStream.range(0,arr.length).filter(i-> max > arr[i]).map(i->arr[i]).max().getAsInt();
    }
    private static void P4(int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++) bw.write("*");
            bw.newLine();
        }
        for(int i=n-1;i>=1;i--){
            for(int j=0;j<i;j++) bw.write("*");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    private static void P5(int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=(2*n)-1;i>=1;i-=2){
            for(int j=0;j<((2*n)-1-i)/2;j++) bw.write(" ");
            for(int j=0;j<i;j++) bw.write("*");
            bw.newLine();
        }
        for(int i=3;i<=(2*n)-1;i+=2){
            for(int j=0;j<((2*n)-1-i)/2;j++) bw.write(" ");
            for(int j=0;j<i;j++) bw.write("*");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    private static void P6(int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if(j%2==1) bw.write("*");
                else bw.write(" ");
            }
            bw.newLine();
            for(int j=1;j<=n;j++) {
                if(j%2==0) bw.write("*");
                else bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // int[] score = new int[5];
        // int scoreNum = 0;
        // for(int i=0;i<5;i++) {
        //     score[scoreNum++] = sc.nextInt();
        //     if(score[scoreNum-1] < 40) score[scoreNum-1] = 40;
        // }
        // System.out.println(P1(score));

        // int[] price = new int[5];
        // for(int i=0;i<5;i++) price[i] = sc.nextInt();
        // System.out.println(P2(price));

        // int[] arr = new int[3];
        // for(int i=0;i<3;i++) arr[i] = sc.nextInt();
        // System.out.println(P3(arr));

        int star1 = sc.nextInt();
        // P4(star1);
        // P5(star1);
        P6(star1);
    }
    
}
