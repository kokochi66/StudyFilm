#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool checkPalindrome(char *inputString) {
	int i=0;
	while(i<strlen(inputString)){
        if(inputString[i]!=inputString[strlen(inputString)-1-i]) return false;
        i++;
    }
    return true;
}

int main() {
	if(checkPalindrome("aababa")) printf("True\n");
	else printf("False\n");
	return 0;
}
