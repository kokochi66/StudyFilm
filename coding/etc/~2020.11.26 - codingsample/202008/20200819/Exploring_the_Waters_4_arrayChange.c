#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct arr_integer {
	int size;
	int *arr;
} arr_integer;

arr_integer alloc_arr_integer(int len) {
	arr_integer a = {len, len > 0 ? malloc(sizeof(int) * len) : NULL};
	return a;
}


int arrayChange(arr_integer inputArray) {
	int sum=0, len=inputArray.size,i;
	for(i=1;i<len;i++){
		if(inputArray.arr[i]<=inputArray.arr[i-1]){
			sum+=inputArray.arr[i-1]-inputArray.arr[i]+1;
			inputArray.arr[i] = inputArray.arr[i-1]+1;
		}
	}
	return sum;
}
//나의 풀이

//모범답안 

arr_integer insertEM(arr_integer a, int *b){
	int len = a.size,i;
	for(i=0;i<len;i++) a.arr[i] = b[i];
	return a;
}

int main() {
	arr_integer a = alloc_arr_integer(3);
	int tempA[3] = {1,1,1};
	insertEM(a,tempA);
	printf("%d",arrayChange(a));
}


