import java.util.Arrays;

public class Merge_Sort {
    // https://www.youtube.com/watch?v=ctkuGoJPmAE&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=8
    // 6번째 병합정렬
    public static void main(String[] args){
        int[] a = {1,10,5,8,7,6,4,3,2,9};
        MergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    
    public static void Merge(int[] arr, int m, int middle, int n){
        int[] sorted = new int[n-m+1];
        int i = m, j = middle+1, k = 0;
        //정렬될 값을 저장할 배열 sorted를 선언,
        // 각 변수 i는 분할되어있는 왼쪽 그룹의 첫번째 원소, j는 오른쪽 그룹의 첫번째 원소, k는 sorted를 저장할 위치를 저장하고 있음

        while(i<=middle && j<=n){
            if(arr[i] < arr[j]){
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        // 첫번째 While문은 N번 반복의 일부분이며,
        // 왼쪽배열과 오른쪽배열을 번갈아가면서 확인하면서 병합해나가는 과정이다.

        if(i>middle){
            for(int temp=j;temp<=n;temp++){
                sorted[k++] = arr[temp];
            }
        } else if(j>n){
            for(int temp=i;temp<=middle;temp++){
                sorted[k++] = arr[temp];
            }
        }
        // 두번째 반복은 첫번째 while문을 통해 왼쪽이나, 오른쪽 둘 중 하나의 배열이 끝난 상태로,
        // 나머지 하나의 배열을 정렬되는 배열안에 모두 넣는다.

        k = m;
        for(int temp=0;temp<sorted.length;temp++){
            arr[k++] = sorted[temp];
        }
        // 마지막 반복은 정렬된 배열을 입력된 배열안에 넣어준다.
    }
    public static void MergeSort(int[] arr, int m, int n){
        if(m<n){
            // m==n이면 그대로 반환 (분할된 개수가 1인 경우에는 정렬을 해 줄 필요가 없음.)
            int middle = (m+n)/2;
            MergeSort(arr,m,middle);
            MergeSort(arr,middle+1,n);
            // MergeSort를 양쪽 분할해서 적용하기 때문에 양쪽의 분할된 배열값은, 각각의 분할된 영역에서 정렬된 상태로 반환됨.
            // 분할 자체에는 Log N 만큼의 연산이 수행됨.

            Merge(arr, m, middle, n);
            // 분할된 값을 병합하는 과정에서 N의 평균연산이 수행됨.
        }
        // 최종 시간복잡도는 분할과정인 Log N에 병합과정 N을 합쳐서 O(N*Log N)이 됨.
        // 이 경우, 퀵정렬에 비해 어느정도 정렬된 상태엔 배열에도 일정한 연산 수를 보장할 수 있으나,
        // 실질적으로 평균적으로 퀵 정렬보다 연산이 빠르지는 않음.
    }
}
