import java.io.*;
import java.math.BigInteger;

public class SortBKJ {
    // https://www.acmicpc.net/problem/10610 30
    public static void main(String[] args) throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        // BigInteger BI = new BigInteger(input);
        // StringBuilder TP = new StringBuilder(input);
        int[] arr = new int[input.length()];
        int TP;
        for(int i=0;i<arr.length;i++) arr[i] = input.charAt(i)-'0';
        if(arr.length == 1) Write.write("-1");
        // 입력값이 두자릿수가 아니면 30의 배수가 될 수 없음
        else {
            for(int i=1;i<arr.length;i++){
                int c=i, root;
                do {
                    root = (c-1)/2;
                    if(arr[c] < arr[root]){
                        TP = arr[root];
                        arr[root] = arr[c];
                        arr[c] = TP;
                    }
                    c = root;
                } while(c!=0);
            }
            if(arr[0] != 0) Write.write("-1");
            // 최소값이 0이 아니라면 30의 배수가 될 수 없음.
            else {
                int sum = 0;
                for(int i=arr.length-1;i>=0;i--){
                    sum += arr[0];
                    // 0은 sum에 더해도 0이므로 첫번째 값을 더해도 상관없음.
                    TP = arr[0];
                    arr[0] = arr[i];
                    arr[i] = TP;

                    int c = 0, next;
                    do {
                        next = c*2+1;
                        if(next+1<i && arr[next+1] < arr[next]) next++;
                        if( next<i && arr[c] > arr[next]){
                            TP = arr[next];
                            arr[next] = arr[c];
                            arr[c] = TP;
                        }
                        c = next;
                    } while(c<i);
                }
                if(sum%3==0){
                    for(int i=0;i<arr.length;i++) Write.write(arr[i]+"");
                } else Write.write("-1");
                // 모든 자릿수의 합을 더해서 3의 배수가 되지 않으면 30의 배수가 될 수 없음.
            }


        }
        Write.flush();
        Write.close();
        Read.close();

    }
}