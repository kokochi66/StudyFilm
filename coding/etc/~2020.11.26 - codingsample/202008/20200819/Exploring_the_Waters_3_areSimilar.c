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


bool areSimilar(arr_integer a, arr_integer b) {
	if(a.size != b.size) return false;
	int len = a.size,i,errpoint=-1;
	for(i=0;i<len;i++){
		if(a.arr[i]!=b.arr[i]){
			if(errpoint!=-1){
				if(errpoint==-2) return false;
				else if(a.arr[errpoint]==b.arr[i]&&a.arr[i]==b.arr[errpoint]) errpoint=-2;
				else return false;
			}
			else errpoint=i;
		}
	}
	if(errpoint>-1) return false;
	return true;
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
	arr_integer b = alloc_arr_integer(3);
	int tempA[3] = {1,2,3};
	int tempB[3] = {1,2,3};
	insertEM(a,tempA);
	insertEM(b,tempB);
	if(areSimilar(a,b)) printf("True\n");
	else printf("False\n");
}


