#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

int circleOfNumbers(int n, int firstNumber) {
    return (firstNumber+(n/2))%n;
}


int main() {
	printf("%d\n",circleOfNumbers(10,2));
}


