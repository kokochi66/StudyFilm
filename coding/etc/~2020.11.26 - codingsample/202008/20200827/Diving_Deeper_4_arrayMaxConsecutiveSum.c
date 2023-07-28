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

int arrayMaxConsecutiveSum(arr_integer a, int k) {
	int max=0,i,j,temp=0;
    for(i=0;i<k;i++) max+=a.arr[i];
    temp = max;
	for(i=1;i<a.size-k+1;i++){
		temp=temp-a.arr[i-1]+a.arr[i+k-1];
		if(max<temp) max=temp;
	}
	return max;
}

int main() {
	char *a = "cabac";
	printf("%d\n",differentSymbolsNaive(a));
	return 0;
}


