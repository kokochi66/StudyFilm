#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

int depositProfit(int deposit, int rate, int threshold) {
    float temp = deposit; 
    int year = 0;
    while(temp<threshold){
        temp = (temp*(rate+100))/100;
        year++;
    }
    return year;
}

int depositProfit2(int deposit, int rate, int threshold) {
    double temp = (double) threshold / (double) deposit;
    double rat2 = (double) 1+(rate*0.01);
    return ceil(log(temp)/log(rat2));
}



int main() {
	printf("%d\n",depositProfit2(100,20,170));
}


