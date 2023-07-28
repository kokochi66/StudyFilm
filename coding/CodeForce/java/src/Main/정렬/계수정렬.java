package src.Main.정렬;

import java.util.Arrays;

public class 계수정렬 {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
                3, 4, 4, 3, 5, 1, 2, 3, 5, 2, 3, 1, 4, 3, 5, 1, 2, 1, 1, 1};
        CountingSort(a, 5);
        System.out.println(Arrays.toString(a));
    }

    public static void CountingSort(int[] arr, int max) {
        // 배열과 배열의 최댓값 max를 입력으로 받는다.
        int[] temp = new int[max];
        // 최댓값만큼의 개수를 저장할 임시배열 temp를 선언
        for (int i = 0; i < max; i++) temp[i] = 0;
        // temp의 모든 값을 0으로 초기화해준다.
        for (int i = 0; i < arr.length; i++) {
            // arr배열을 돌면서 (N연산) 각 수치의 개수를 temp에 추가시켜준다.
            temp[arr[i] - 1]++;
        }
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                arr[k++] = i + 1;
            }
        }
        // 개수를 센 값을 기존의 배열 arr에 추가해준다.
        // 시간복잡도 = O(n)
        // 배열에서 특정 조건에 맞는 값을 정렬한 채로 반환하는데 좋음. 효율도 뛰어남.
    }
}
