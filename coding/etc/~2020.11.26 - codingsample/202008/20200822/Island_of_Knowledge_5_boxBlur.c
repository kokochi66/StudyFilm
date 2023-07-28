#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

int sum3(int a,int b, int c){
    return a+b+c;
}

arr_arr_integer boxBlur(arr_arr_integer image) {
    arr_arr_integer output = alloc_arr_arr_integer(image.size-2);
    int i,j,k,temp;
    for(i=0;i<output.size;i++){
        output.arr[i] = alloc_arr_integer(image.arr[0].size-2);
        for(j=0;j<output.arr[i].size;j++){
            temp=0;
            for(k=j;k<=j+2;k++) temp+=sum3(image.arr[i].arr[k],image.arr[i+1].arr[k],image.arr[i+2].arr[k]);
            output.arr[i].arr[j] = temp/9;
        }
    }
    return output;
}


