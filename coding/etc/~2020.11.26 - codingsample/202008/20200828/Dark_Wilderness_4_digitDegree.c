#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int digitDegree(int n) {
    int count = 0,temp;
    while(n/10 != 0){
        count++;
        temp = n;
        n = 0;
        while(temp != 0){
            n += temp%10;
            temp /= 10;
        }
        printf("%d\n",n);
    }
    return count;
}

int main(void){
    printf("%d\n",digitDegree(777773));
    return 0;
}