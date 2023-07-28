#include <stdio.h>
#include <stdlib.h>

typedef struct arr_integer {
	int size;
	int *arr;
} arr_integer;

arr_integer alloc_arr_integer(int len) {
	arr_integer a = {len, len > 0 ? malloc(sizeof(int) * len) : NULL};
	return a;
}

arr_integer alternatingSums(arr_integer a) {
	arr_integer output = alloc_arr_integer(2);
	output.arr[0]=0;
	output.arr[1]=0;a
	int i;
	for(i=0;i<a.size;i++){
		output.arr[i%2]+=a.arr[i];
	}
	return output;
}

int main() {
	arr_integer a = alloc_arr_integer(5);
	int i;
	int var[5] = {50,60,60,45,70};
	for (i=0;i<5;i++){
		a.arr[i] = var[i];
	}
	a = alternatingSums(a);
	for(i=0;i<a.size;i++){
		printf("%d ",a.arr[i]);
	}
}


