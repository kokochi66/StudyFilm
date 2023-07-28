
import java.io.*;
import java.util.StringTokenizer;

public class SortBKJ1101 {
    //https://www.acmicpc.net/problem/2752 세수정렬
    public static void main(String[] args) throws Exception{
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(Read.readLine()," ");
        int[] arr = new int[3];
        for(int i=0;i<3;i++) arr[i] = Integer.parseInt(tok.nextToken());

        int temp;
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j] < arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        for(int i=0;i<3;i++) System.out.print(arr[i]+" ");
    }
}
