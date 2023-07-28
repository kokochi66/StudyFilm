package Algorithms_java.Sort;

import java.util.Arrays;
public class AL_Heap_Sort {
    public static void main(String[] args){
        int[] a = {1,10,5,8,7,6,4,3,2,9};
        HeapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void HeapSort(int[] arr){
        if(arr.length<=1) return;
        // 예외처리. 길이가 1 이하이면 정렬할 이유가 없음.
        // 먼저 입력된 배열을 최대힙 구조로 만들어준다.
        // 상향식 힙 만들기 방식을 채택
        int temp;
        // 스와핑을 위한 변수 temp를 초기화

        for(int i=1;i<arr.length;i++){
            //두번째 값부터 마지막값까지 최댓값을 올려주는 연산
            int c = i;
            do {
                int root = (c-1)/2;
                // 현재 c의 상위 노드값을 확인
                if(arr[root] < arr[c]){
                    // 상위 노드값이 현재 값보다 작다면 스와핑해준다.
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                c = root;
                // 현재 확인값을 상위노드로 이동
            } while(c!=0);
        }
        // 최대힙 만들기 => O(Log N * N) 연산이 든다.

        for(int i=arr.length-1;i>=0;i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int root = 0, c;
            do {
                c = (root*2) +1;
                // 비교할 수인 c값은 현재 root노드의 왼쪽 노드로 이동
                if(c<i-1 && arr[c] < arr[c+1]) c++;
                // 오른쪽 노드가 더 크다면 오른쪽 노드를 c로 잡음. 여기서 c가 i이상이 되면 안됨.
                if(c<i && arr[root] < arr[c]) {
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                root = c;
            } while(c<i);
        }
        // 총 연산은 N*Log N 연산을 2번한 2N*Log N 이며 O(N * Log N) 이 된다.
    }
}
