package src.Main.정렬;

import java.util.Arrays;

public class 퀵정렬 {
    public static void main(String[] args) {
        int[] a = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        QuickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void QuickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        //start==end이거나 역전되었다면 그대로 반환
        int temp, i, j, pivot;
        // 스와핑을 위한 변수 temp와 앞의 값 i, 뒤의 값 j 그리고 pivot을 초기화한다.

        pivot = arr[start];
        i = start + 1;
        j = end;
        while (i <= j) {    //엇갈리지 않은 동안 반복
            while (i <= end && pivot >= arr[i]) i++;
            while (j > start && pivot <= arr[j]) j--;
            // i와 j가 end, start 범위 내부에서만 연산이 되도록 보장해주어야한다!
            if (i >= j) {
                arr[start] = arr[j];
                arr[j] = pivot;
                // 연산결과 엇갈리게 되었다면 pivot과 i의 위치를 바꾸어줌.
            } else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // 엇갈리지 않았다면 i와 j를 스와핑함
            }
        }
        QuickSort(arr, start, j - 1);
        QuickSort(arr, j + 1, end);
        // 시간 복잡도는 평균 O(N*Log N)이나,
        // 이미 정렬되어있거나, 거의 정렬된 배열에 대해서는 시간복잡도가 급격히 상승한다
        // 거의 정렬된 배열의 경우 삽입정렬이 훨씬 유리하다.
    }
}
