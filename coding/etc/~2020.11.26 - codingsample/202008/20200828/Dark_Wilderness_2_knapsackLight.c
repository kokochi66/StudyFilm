#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    return maxW>=(weight1+weight2) ? (value1+value2) : maxW<value1 ? (maxW<value2 ? 0 : value2) : (maxW<value2 ? value1 : (value1>value2 ? value1 : value2));
}

int main(void){
    printf("%d\n",knapsackLight(10,5,6,4,8));
    return 0;
}