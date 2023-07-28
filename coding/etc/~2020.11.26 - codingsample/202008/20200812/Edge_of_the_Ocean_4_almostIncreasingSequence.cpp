#include <stdio.h>
// (sizeof(sequence)/sizeof(int))
bool almostIncreasingSequence(arr_integer sequence) {
    int p=-1,c=0,i;
    for(i=1;i<sequence.size;i++) 
    if(sequence.arr[i-1]>=sequence.arr[i])
        {
            p=i;
            c++;
        }    
    if(c>1) return false;
    if(c==0) return true;
    if(p==sequence.size-1) return true;
    if(p==1) return true;
    if(sequence.arr[p-1]<sequence.arr[p+1]) return true;
    if(sequence.arr[p-2]<sequence.arr[p]) return true;
    return false;
}

//C언어는 자체적으로 배열의 개수를 세는 함수가 제한되여 구현불가 
