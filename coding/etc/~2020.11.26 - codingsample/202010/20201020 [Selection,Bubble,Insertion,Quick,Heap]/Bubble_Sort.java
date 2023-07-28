import java.util.Arrays;

public class Bubble_Sort {
    // https://www.youtube.com/watch?v=EZN0Irp2aPs&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=3
    // 2강 버블정렬
    // 
    public static void main(String[] args){
        int[] a = {1,10,5,8,7,6,4,3,2,9};
        BubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void BubbleSort(int[] arr){
        int temp;
        // 인접할 값을 스와핑 할 변수인 temp만을 초기화해주면 됨.
        for(int i=0;i<arr.length;i++){
            //총 반복회수는 n번
            for(int j=0;j<arr.length-1-i;j++){
                //정렬 한 텀을 할 때마다 j값은 0부터 n-1에 이미 정렬된 맨 뒤자리인 i번째의 이전값까지만 스와핑을 해주면 됨.
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                // 이전값이 더 크다면 값을 스와핑해줌.
            }
        }
        // 시간복잡도는 선택정렬과 동일한 O(n^2) 이지만,
        // 매 반복마다 스와핑이 이루어지기 때문에 기본 연산자체에 상수배가 많아서 버블정렬은 모든 정렬중에 가장 효율이 안좋음.
    }
}
