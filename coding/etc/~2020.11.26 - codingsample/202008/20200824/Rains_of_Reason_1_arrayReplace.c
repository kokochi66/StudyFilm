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

arr_integer arrayReplace(arr_integer inputArray, int elemToReplace, int substitutionElem) {
	int i;
	for(i=0;i<inputArray.size;i++) if(inputArray.arr[i]==elemToReplace) inputArray.arr[i]=substitutionElem;
	return inputArray;
}


int main() {
	arr_integer input = alloc_arr_integer(3);
	int a[3] = {1, 2, 1};
	insertEM(input,a);
	int i;
	arrayReplace(input,1,3);
	for(i=0;i<input.size;i++) printf("%d\n",input.arr[i]);
	
}


