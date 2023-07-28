#include <stdio.h>
//주어진 정수배열을 순서대로 했을 때, 빠진 정수의 개수를 반환 

int makeArrayConsecutive2(arr_integer s) {
    int max = s.arr[0];
    int min = s.arr[0];
    for(int i = 1; i < s.size; i++) {
        if(max < s.arr[i]) max = s.arr[i];
        if(min > s.arr[i]) min = s.arr[i];
    }
    return max - min - s.size + 1;
}

//C언어는 함수자체적으로 배열의 길이를 구하는 방법이 제한되어 구현불가
