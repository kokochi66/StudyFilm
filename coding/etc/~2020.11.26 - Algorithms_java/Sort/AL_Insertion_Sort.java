package Algorithms_java.Sort;

import java.util.Arrays;
public class AL_Insertion_Sort {
    public static void main(String[] args){
        int[] a = {1,10,5,8,7,6,4,3,2,9};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void InsertionSort(int[] arr){
        int temp, j;
        // 값을 스와핑할 변수 temp와 스와핑하는 스위치값 j를 초기화한다.
        for(int i=0;i<arr.length-1;i++){
            //기본 반복은 어짜피 마지막 직전까지 삽입정렬이 이루어지면 맨 뒤에는 최댓값이 남기때문에 n-1번만 해주면 됨.
            j = i;
            // j값을 현재 위치로 초기화시켜줌.
            while(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }
        // 최종 시간복잡도는 마찬가지로 O(n^2) 이지만
        // 필요한 만큼의 연산만을 진행하기 때문에 평균적인 연산속도가 n^2중에서는 빠른편에 속한다.
    }
    
}
