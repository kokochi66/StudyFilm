#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

arr_arr_integer minesweeper(arr_arr_boolean matrix) {
    arr_arr_integer output = alloc_arr_arr_integer(matrix.size);
    int i,j,k,l;
    for(i=0;i<output.size;i++){
        output.arr[i] = alloc_arr_integer(matrix.arr[0].size);
        for(j=0;j<output.arr[i].size;j++) output.arr[i].arr[j] = 0;
    }
    for(i=0;i<output.size;i++){
        for(j=0;j<output.arr[0].size;j++){
            if(matrix.arr[i].arr[j]){
                for(k=i-1;k<=i+1;k++){
                    for(l=j-1;l<=j+1;l++){
                        if(k>=0&&k<=output.size-1&&l>=0&&l<=output.arr[i].size-1){
                            if(k==i&&l==j) output.arr[k].arr[l]+=0;
                            else output.arr[k].arr[l]++;
                        }
                    }
                }
            }
        }
    }
    return output;
}

