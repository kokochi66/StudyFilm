import java.util.*;
import java.io.*;

public class SortBKJ2 {
    // 1. https://www.acmicpc.net/problem/1181 단어 정렬
    // 2. https://www.acmicpc.net/problem/11650 좌표정렬하기
    // 3. https://www.acmicpc.net/problem/1026 보물
    public static void main(String[] args) throws Exception {
        // Solution();
    }

    public static void SortBKJ2_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        String[] arr = new String[n];
        HashSet<String> duplicate = new HashSet<String>();

        int k = 0;
        for(int i=0;i<n;i++) {
            input = Read.readLine();
            if(!duplicate.contains(input)) {
                arr[k++] = input;
                duplicate.add(input);
            }
        }
        
        String temp;
        for(int i=1;i<k;i++){
            int j=i;
            while(j>0 && ((arr[j].length() < arr[j-1].length()) 
            || (arr[j].length() == arr[j-1].length() && arr[j].compareTo(arr[j-1])<0))){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

    
    for(int i=0;i<k;i++) System.out.println(arr[i]);
 
    }
    public static void SortBKJ2_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[][] arr = new int[n][2];

        int k = 0;
        for(int i=0;i<n;i++) {
            input = Read.readLine();
            String[] token = input.split(" ");
            arr[i][0] = Integer.parseInt(token[0]);
            arr[i][1] = Integer.parseInt(token[1]);
        }
        
        // 배열의 최대가 100,000 이므로 n^2연산 불가능
        // Heap 정렬 이용.
        int[] temp = new int[2];
        for(int i=1;i<arr.length;i++){
            int c = i, root;
            do {
                root = (c-1)/2;
                if(arr[c][0] < arr[root][0] || (arr[c][0] == arr[root][0] && arr[c][1] < arr[root][1])){
                    // x좌표가 더 큰 값을 첫번째 기준으로 최대힙 구성
                    // x좌표가 같다면 y좌표가 더 큰 값을 기준으로 최대힙 구성
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }

        for(int i=arr.length-1;i>=0;i--){
            Write.write(arr[0][0]+" "+arr[0][1]);
            Write.newLine();
            arr[0] = arr[i];
            int c=0, next;
            do {
                next = (c*2)+1;
                if((next+1)<i && 
                    (arr[next+1][0] < arr[next][0] || (arr[next+1][0] == arr[next][0] && arr[next+1][1] < arr[next][1]))) {
                        next++;
                }

                if(next<i && 
                    (arr[c][0] > arr[next][0] || (arr[c][0] == arr[next][0] && arr[c][1] > arr[next][1]))) {
                        temp = arr[c];
                        arr[c] = arr[next];
                        arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

        // for(int i=0;i<arr.length;i++) System.out.println(Arrays.toString(arr[i]));
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ2_3() throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[][] SwitB = new int[n][2];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        for(int i=0;i<n;i++) b[i] = sc.nextInt();
        for(int i=0;i<n;i++) {
            SwitB[i][0] = b[i];
            SwitB[i][1] = i;
        }
        int temp;
        for(int i=1;i<a.length;i++){
            int j=i;
            while(j>0 && a[j] < a[j-1]){
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
        }
        int[] temparr = new int[2];
        for(int i=1;i<SwitB.length;i++){
            int j=i;
            while(j>0 && SwitB[j][0] > SwitB[j-1][0]){
                temparr = SwitB[j];
                SwitB[j] = SwitB[j-1];
                SwitB[j-1] = temparr;
                j--;
            }
        }
        int Sum = 0;
        for(int i=0;i<n;i++) {
            Sum += (a[i]*SwitB[i][0]);
        }
        System.out.println(Sum);
        // for(int i=0;i<SwitB.length;i++) System.out.println(Arrays.toString(SwitB[i]));
        // System.out.println(Arrays.toString(b));
    }

}
