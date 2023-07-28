#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

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

int avoidObstacles(arr_integer inputArray) {
	int i,j;
	for(i=2;i<1002;i++){
		for(j=0;j<inputArray.size;j++){
			if(inputArray.arr[j]%i==0) break;
			else if(j==inputArray.size-1&&inputArray.arr[j]%i!=0) return i;
		}
	}
	return 1;
}


int main() {
	arr_integer input = alloc_arr_integer(5);
	int a[5] = {5,3,6,7,9};
	insertEM(input,a);
	printf("%d",avoidObstacles(input));
	
}


