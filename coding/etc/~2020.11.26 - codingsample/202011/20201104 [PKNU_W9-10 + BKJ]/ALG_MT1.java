import java.util.Arrays;

public class ALG_MT1 {
    // 알고리즘 과목 시험준비 코딩

    public static void main(String[] args){
        // int[] a = {1,2,3,4,5,6,7};
        // System.out.println(Num2_Binary_Search(a,5));

        // System.out.println(Num4_Fibonacci_Term2(9));
        int[] b = {5,7,1,3,4,6,2,5,0,9};
        Num5_Exchange_Sort(b);
        System.out.println(Arrays.toString(b));
    }

    public static void Num5_Exchange_Sort(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        // 시간복잡도 : if문 기준 = n(n-1)/2
        // exchange 연산 기준 = B(n) = 0, W(n) = n(n-1)/2
    }
    public static int Num4_Fibonacci_Term2(int x){
        // 4번째 문제:: 피보나치 수열 만들기 - 동적계획 활용
        int[] arr = new int[x+1];
        arr[0] = 0;
        if(x>0){
            arr[1] = 1;
            for(int i=2;i<=x;i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[x];
        // T(n) = n+1 == O(n)
    }
    public static int Num3_Fibonacci_Term(int x){
        // 3번째 문제 피보나치 수열 만들기 - 분할정복 활용
        if(x<=1) return x;
        return Num3_Fibonacci_Term(x-1) + Num3_Fibonacci_Term(x-2);
        // T(n) = M(2^(n/2))
    }
    public static int Num2_Binary_Search(int[] arr, int x){
        // 2번 알고리즘 Binary Search
        // 정렬된 배열에서만 사용 가능한 탐색 알고리즘 - 분할정복을 이용
        int low=1, mid, high=arr.length;
        while(low <= high) {
            mid = (low+high)/2;
            if(arr[mid-1] == x) return mid-1;
            else if(arr[mid-1] > x) high = mid-1;
            else low = mid+1;
        }
        return -1;
        // B(n) = 1, W(n) = S(Log N)
        // T(n) = O(Log N)
    }
    public static int Num1_Sequential_Search(int[] arr, int x){
        // 1번 알고리즘 Sequnetial Search
        // 배열에서 원하는 값을 찾아, 해당 location을 반환하는 함수.
        int index =0;
        while(index<arr.length && arr[index] != x) index++;
        return index == arr.length ? 0 : index;
        // 배열을 전체 순환하기 때문에 
        // B(n) = 1, W(n) = n == O(n)
    }
}
