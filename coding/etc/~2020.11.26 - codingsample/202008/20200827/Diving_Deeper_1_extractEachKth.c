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

arr_integer extractEachKth(arr_integer a, int k) {
	arr_integer output = alloc_arr_integer(a.size-(a.size/k));
	int i,outNum=0;
	for(i=0;i<a.size;i++) if((i+1)%k!=0) output.arr[outNum++]=a.arr[i];
	return a;
}


void pop(arr_integer* inputArray, int index)
{   
    for (int i=index; i<(inputArray->size)-1; i++)
        inputArray->arr[i] = inputArray->arr[i+1];
    
    (inputArray->size)--;
}

arr_integer extractEachKth2(arr_integer inputArray, int k) {
    int removed = 0;
    int size = inputArray.size;
        
    for (int i=0; i<size; i++)
        if ((i+1)%k == 0) pop(&inputArray, i-removed++);
    
    return inputArray;
}

int main() {
	int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	arr_integer in = alloc_arr_integer(10);
	insertEM(in,a);
	extractEachKth(in,5);
	int i;
	printf("%d\n",in.size);
	for(i=0;i<in.size;i++) printf("%d\n",in.arr[i]);
	return 0;
}


