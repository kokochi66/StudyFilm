#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

bool evenDigitsOnly(int n) {
	int temp;
	while(n!=0){
		temp = n%10;
		if(temp%2!=0) return false;
		n/=10;
	}
	return true;
}


int main() {
	int a = 248622;
	int b = 642386;
	if(evenDigitsOnly(a)) printf("True\n");
	else printf("False;");
}


