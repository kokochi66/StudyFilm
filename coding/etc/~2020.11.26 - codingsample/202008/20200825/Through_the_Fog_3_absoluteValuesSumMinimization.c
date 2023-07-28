#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

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

int countcloset(arr_integer a,int swit) {
	int i=0,len=a.size;
	int sum=0;
	for(i=0;i<len;i++){
		if(i!=swit) sum+=abs(a.arr[swit]-a.arr[i]);
	}
	return sum;
}

int absoluteValuesSumMinimization(arr_integer a) {
    int i;
    int min=countcloset(a,0),temp,swit=0;
    for(i=1;i<a.size;i++){
        temp = countcloset(a,i);
        if(min>temp) {
            min = temp;
            swit = i;
        }
    }
    return a.arr[swit];
}



int main() {
  printf("Hello world!, æ»≥Á«œººø‰!\n");
}


