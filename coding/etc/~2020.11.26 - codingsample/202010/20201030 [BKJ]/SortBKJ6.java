import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortBKJ6 {
    public static void main(String[] args) throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int k = Integer.parseInt(tok.nextToken());

        int[] arr = new int[n];
        int size = 0;
        tok = new StringTokenizer(Read.readLine());
        // n과 k의 크기는 최대 500만이다.
        // 2의 20승이 100만이기 때문에, 500만은 약 2의 22승
        // 22 * 500만 = 1억이 넘어가나,
        // 입력과 함께 최소힙을 구현하면 실제 수는 N * Log N 보다 상당히 적을 것이다.
        // 이를 이용해서, 최소힙을 통해 출력을 내도록 한다.
        // 어쩌피 입력값이 10^9 절댓값이기 때문에, 계수정렬은 안된다. => N*Log N을 활용해야함.

        int temp;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tok.nextToken());
            int c = i, root;
            do {
                root = (c-1)/2;
                if(arr[root] > arr[c]) {
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                c = root;
            } while(c!=0);
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr.length - i == k) {
                System.out.println(arr[0]);
                break;
            }
            arr[0] = arr[i];
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next] > arr[next+1]) next++;
                if(next<i && arr[next] < arr[c]) {
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

    }
}
