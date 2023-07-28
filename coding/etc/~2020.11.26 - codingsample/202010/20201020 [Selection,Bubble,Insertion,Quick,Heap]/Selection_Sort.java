import java.util.Arrays;

public class Selection_Sort {
    // 기본 실전 알고리즘 개념이 너무 부족하다는걸 많이 느낌.
    // 실전 알고리즘 강의부터 착실히 다시 시작해나가겠음.
    // https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=2
    // 1강 선택정렬(Selection_Sort)

    public static void main(String[] args){
        int[] a = {1,10,5,8,7,6,4,3,2,9};
        SelectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void SelectionSort(int[] arr){
        int index, temp, min;
        // 최솟값의 위치를 저장할 index와 최솟값을 저장할 min, 값을 스와핑할 때 사용할 변수 temp를 선언한다.
        for(int i=0;i<arr.length;i++){
            min = arr[i];
            index = i;
            // 기본 최솟값은 배열을 반복하는 맨 앞의 값, i로 지정, i+1부터 돌면서 더 최소값이 있는지를 파악
            for(int j=i+1;j<arr.length;j++){
                // n^2의 연산이 이루어진다.
                if(arr[j]<min) {
                    index = j;
                    min = arr[j];
                }
            }

            // 파악한 최소값과 맨앞의 값을 스와핑함.
            temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    // 시간복잡도 = O(n^2)
}
