import java.io.*;
import java.util.*;

public class BKJ_BF1102 {
    // 1. https://www.acmicpc.net/problem/2798 블랙잭
    // 2. https://www.acmicpc.net/problem/2231 분해합
    // 3. https://www.acmicpc.net/problem/7568 덩치

    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        // Solution();
    }

    public static void BKJ_BF1102_1() throws Exception{
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int BLJ = Integer.parseInt(tok.nextToken());
        int[] arr = new int[n];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
        //입력부분
        
        int max = 0;
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    int sum = arr[i] + arr[j]+ arr[k];
                    if(sum <= BLJ && sum>max) max = sum;
                }
            }
        }

        Write.write(max+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ_BF1102_2() throws Exception{
        String input = Read.readLine();
        int n = input.length()*9;
        int num = Integer.parseInt(input);
        int firs = num;
        boolean pass = false;
        for(int i=num-n;i<=num;i++){
            int DS = 0, temp = i;
            while(temp>0){
                DS += temp%10;
                temp /= 10;
            }
            if(i+DS == num) {
                num = i;
                n = num+"".length()*9;
                break;
            } else if(i==num) {
                pass = true;
                if(num == firs) num = 0;
                break;
            }
        }

        Write.write(num+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ_BF1102_3() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer tok = new StringTokenizer(Read.readLine());
            arr[i][0] = Integer.parseInt(tok.nextToken());
            arr[i][1] = Integer.parseInt(tok.nextToken());
        }

        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=0;j<n;j++){
                if(j!=i && arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]){
                    count++;
                }
            }
            Write.write(count+" ");
        }

        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ_BF1102_4() throws Exception{
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        int h = Integer.parseInt(tok.nextToken());
        int w = Integer.parseInt(tok.nextToken());
        char[][] arr = new char[h][w];
        for(int i=0;i<h;i++){
            String input = Read.readLine();
            arr[i] = input.toCharArray();
        }
        int min = 64;
        for(int FstHor=0;FstHor<=w-8;FstHor++){
            for(int FstVer=0;FstVer<=h-8;FstVer++){
                int countC1 = 0;
                int countC2 = 0;
                // System.out.println("THIS IS == "+FstHor+"    "+FstVer+"   :::: ");
                for(int i=FstVer;i<FstVer+8;i++){
                    for(int j=FstHor;j<FstHor+8;j++){
                        char target = 'W';
                        if((i-FstVer)%2==(j-FstHor)%2) target = 'W';
                        else  target = 'B';
                        if(arr[i][j] != target) countC1++;
                        else countC2++;
                        // System.out.println(i+" "+j+"   "+((i-FstVer)%2==(j-FstHor)%2)+"   "+target+"  "+countC1);
                    }
                }
                if(Math.min(countC1, countC2) < min)  min = Math.min(countC1, countC2);
                // System.out.println(FstVer+" "+FstHor+"  "+min+"   "+count);
            }
        }

        Write.write(min+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void BKJ_BF1102_5() throws Exception{
        String input = Read.readLine();
        int n = Integer.parseInt(input);

        int count = 1;
        long Num = 666;
        while(count < n){
            Num++;
            long temp = Num;
            while(temp >= 666){
                if(temp%1000 == 666){
                    count++;
                    break;
                } else temp /= 10;
            }
        }
        Write.write((Num)+"");
        Write.flush();
        Write.close();
        Read.close();
    }
}
