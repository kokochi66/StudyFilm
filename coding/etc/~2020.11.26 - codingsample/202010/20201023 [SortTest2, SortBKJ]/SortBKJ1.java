import java.io.*;
import java.util.*;

public class SortBKJ1 {
    // 1. https://www.acmicpc.net/problem/2750 수 정렬하기
    // 2. https://www.acmicpc.net/problem/11399 ATM
    // 3. https://www.acmicpc.net/problem/2751 수 정렬하기 2
    // 4. https://www.acmicpc.net/problem/1427 소트 인사이드
    // 5. https://www.acmicpc.net/problem/10989 수 정렬하기 3
    // 6. https://www.acmicpc.net/problem/1931 회의실 배정

    public static void main(String[] args) throws Exception {
    }
    public static void SortBKJ1_1() throws Exception {

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        int temp;
        for(int i=0;i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
        }
        // 배열값 입력 완료

        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

        for(int i=0;i<n;i++) {
            Write.write(arr[i]+"");
            Write.newLine();
        }
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ1_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] person = new int[n];
        int[] sum = new int[n];
        int outputSum = 0;
        input = Read.readLine();
        String[] inputToken = input.split(" ");
        for(int i=0;i<n;i++){
            person[i] = Integer.parseInt(inputToken[i]);
        }
        //총 배열을 입력 완료.
        //person은 각 사람이 돈을 뽑는데까지 걸리는 시간인 입력값이 저장
        //Sum에는 정렬된 상태에서 각 사람이 총 기다리는 시간이 저장 될 것임.
        //최대 수는 1000이기때문에 정렬은 Insertion으로 문제가 없음.

        int temp;
        for(int i=1;i<person.length;i++){
            int j = i;
            while(j>0 && person[j]<person[j-1]){
                temp = person[j];
                person[j] = person[j-1];
                person[j-1] = temp;
                j--;
            }
        }
        // 삽입정렬 완료

        for(int i=0;i<n;i++){
            if(i>0) sum[i] = sum[i-1] + person[i];
            else sum[i] = person[i];
            outputSum += sum[i];
        }
        Write.write(outputSum+"");
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ1_3() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
        }
        //배열 입력완료
        //총 arr의 길이 개수는 절댓값 100만이므로 +-100만으로, temp길이 200만 만큼이 필요함.
        //200만 이므로 연산회수는 문제없을듯
        int[] temp = new int[2000001];
        // 200만 길이로 하여 -100만부터 0으로 적용함, 실제 값 적용할때 -100만연산을 넣어주면서 진행
        
        for(int i=0;i<temp.length;i++) temp[i] = 0; // 200만 연산으로 초기화
        // 현재까지 약 최대 300만연산

        for(int i=0;i<n;i++){
            temp[arr[i]+1000000]++;
        }
        // 배열의 각 값을 temp에 적용 약 100만연산 추가로, 약 현재까지 400만연산
        int k = 0;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i];j++){
                arr[k] = i-1000000;
                Write.write(arr[k]+"");
                Write.newLine();
                k++;
            }
        }
        // 마지막 추가로 적용되는 300만 연산으로 총 약 700만 연산으로 최대연산

        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ1_4() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        char[] arr = new char[input.length()];
        arr = input.toCharArray();
        // char배열로 입력완료
        // 배열의 크기는 최대 10이기 때문에 그냥 간단하게 선택정렬을 이용함.

        int max, maxS;
        char temp;
        for(int i=0;i<arr.length-1;i++){
            max = arr[i]-'0';
            maxS = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]-'0'>max){
                    max = arr[j]-'0';
                    maxS = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[maxS];
            arr[maxS] = temp;
        }
        Write.write(new String(arr));
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ1_5() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
        }
        // n은 최대 천만이므로, 입력만으로 현재 천만연산이 이루어졌음.
        // 각 수는 최대 1만이므로, temp를 이용한 계수정렬을 적용함. 자연수라는 제한이 있으나, 편의를 위해 1부터 저장하며, 배열 길이도 1만1로함
        int[] temp = new int[10001];
        for(int i=0;i<temp.length;i++) temp[i] = 0;
        // temp 배열 초기화 1만연산
        for(int i=0;i<n;i++){
            temp[arr[i]]++;
        }
        // 천만연산을 다시 돌면서 temp에 적절한 값을 추가해줌.

        int k = 0;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i];j++){
                arr[k] = i;
                Write.write(arr[k]+"");
                Write.newLine();
                k++;
            }
        }
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ1_6() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            input = Read.readLine();
            String[] inToken = input.split(" ");
            arr[i][0] = Integer.parseInt(inToken[0]);
            arr[i][1] = Integer.parseInt(inToken[1]);
        }
        // 2차원 배열 내에 시작시간과 끝나는시간을 넣음.
        // 총 개수가 10만이므로, N*Log N 연산인 힙정렬을 통해서 시작시간값을 먼저 정렬함.
        // 여기서 시작시간이 같다면, 끝나는시간이 더 낮은 값이 먼저오도록 함.
        int[] temp = new int[2];
        for(int i=1;i<arr.length;i++){
            int c = i;
            do {
                int root = (c-1)/2;
                if(arr[c][0] > arr[root][0] || (arr[c][0]==arr[root][0] && arr[c][1]>arr[root][1])) {
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }
        int count = 0;
        int CurrRight = arr[0][1]+1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[0][1] <= CurrRight) {
                count++;
                CurrRight = arr[0][0];
            }
            arr[0] = arr[i];
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && (arr[next][0] < arr[next+1][0] || (arr[next][0]==arr[next+1][0] && arr[next][1] < arr[next+1][1]))) next++;
                if(next<i && (arr[c][0] < arr[next][0] || (arr[c][0] == arr[next][0] && arr[c][1] < arr[next][1]))){
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }
        // 시작시간과 끝나는시간을 모두 고려한 힙정렬 완료

        // for(int i=0;i<arr.length;i++) System.out.println(Arrays.toString(arr[i]));
        Write.write(count+"");
        Write.flush();
        Write.close();
        Read.close();
    }
}
