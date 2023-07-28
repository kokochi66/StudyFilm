#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

char * alphabeticShift(char * inputString) {
    int len = strlen(inputString),i;
    for(i=0;i<len;i++) {
        if(inputString[i]=='z') inputString[i]='a';
        else inputString[i] = inputString[i]+1;
    }
    return inputString;
}



int main() {
	char* input = "crazy";
	alphabeticShift(input);
	printf("%s\n",input);
}


