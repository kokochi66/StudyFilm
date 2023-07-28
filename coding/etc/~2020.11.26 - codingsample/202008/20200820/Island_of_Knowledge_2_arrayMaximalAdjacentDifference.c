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

arr_integer insertEM(arr_integer a, int *b){
	int len = a.size,i;
	for(i=0;i<len;i++) a.arr[i] = b[i];
	return a;
}
int arrayMaximalAdjacentDifference(arr_integer inputArray) {
	int sum=0,i;
	for(i=1;i<inputArray.size;i++) if(abs(inputArray.arr[i]-inputArray.arr[i-1])>sum) sum=abs(inputArray.arr[i]-inputArray.arr[i-1]);
	return sum;
}

int main() {
	int a[4] = {2,4,1,0};
	arr_integer input = alloc_arr_integer(4);
	insertEM(input,a);
	int output = arrayMaximalAdjacentDifference(input);
	printf("%d",output);
}


