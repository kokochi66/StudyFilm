import java.io.*;
import java.util.*;

public class SortBKJ4 {
    // 1. https://www.acmicpc.net/problem/10815 숫자카드
    // 2. https://www.acmicpc.net/problem/2217 로프
    public static void main(String[] args) throws Exception{
        // Solution();
    }

    public static void SortBKJ4_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        // 기본입력이 50만 + 50만으로 100만임. = N연산 필수
        // 계수정렬은 불가능함. (주어지는 값 = 1000만)
        // 이미 존재하는 값인지를 확인 => 집합을 사용해보자
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        input = Read.readLine();
        String[] Token = input.split(" ");
        
        HashSet<Integer> Card = new HashSet<Integer>();
        for(int i=0;i<n;i++) Card.add(Integer.parseInt(Token[i]));

        input = Read.readLine();
        n = Integer.parseInt(input);
        input = Read.readLine();
        String[] Token2 = input.split(" ");
        for(int i=0;i<n;i++) {
            if(Card.contains(Integer.parseInt(Token2[i]))) Write.write(1+" ");
            else Write.write(0+" ");
        }

        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ4_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in)); 
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
        }
        int max = 0;
        // 최대값을 유지하고 힙정렬 최소힙으로 최소값을 하나씩 빼보면서 max를 유지해줌

        int temp;
        for(int i=1;i<arr.length;i++){
            int c=i, root;
            do {
                root = (c-1)/2;
                if(arr[root] > arr[c]){
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                } 
                c = root;
            } while(c!=0);
        }
        max = arr[0] * n;

        for(int i=n-1;i>=0;i--){
            int tempMax = arr[0]*(i+1);
            arr[0] = arr[i];
            if(max < tempMax) max = tempMax;
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next+1] < arr[next]) next++;
                if(next<i && arr[next] < arr[c]) {
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

        System.out.println(max);
        Read.close();
    }

}
