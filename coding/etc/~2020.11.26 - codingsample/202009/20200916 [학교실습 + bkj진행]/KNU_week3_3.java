import java.io.*;

public class KNU_week3_3 {
    public static boolean twoPower(int n) throws Exception{     //2의 거듭제곱인지를 판단하는 함수
        int temp = 0, i = 0;
        while(temp < n){
            temp = (int)Math.pow(2,i++);
            if(temp == n) return true;
        }
        return false;
    }
    public static int Eqmeasure(int[] a, int n) throws Exception {    //2부터 n까지 중에 배열안에 존재하는 약수의 개수 출력
        int count = 0;
        for(int i=0;i<a.length;i++) if(n%a[i] == 0) count++;
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String[] inputToken = input.split(" ");
        int n = Integer.parseInt(inputToken[0]);        //~n까지 체크
        int m = Integer.parseInt(inputToken[1]);        //입력되는 정수의 개수
        input = bfr.readLine();
        inputToken = input.split(" ");
        int U = 0, S = 0, L = 0, N = 0, count;
        int[] num = new int[m];
        for(int i=0;i<m;i++) num[i] = Integer.parseInt(inputToken[i]);
        for(int i=1;i<=n;i++) {
            if(twoPower(i)) U++;
            else {
                count = Eqmeasure(num,i);
                if(count >= 3) U++;
                else if(count >= 2) S++;
                else if(count >= 1) L++;
                else N++;
            }
        }
        bfw.write(U + " ");
        bfw.write(S + " ");
        bfw.write(L + " ");
        bfw.write(N + "");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    
}
