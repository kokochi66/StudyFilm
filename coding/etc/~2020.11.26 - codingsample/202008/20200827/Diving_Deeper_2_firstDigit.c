#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

char firstDigit(char * inputString) {
	int i,len=strlen(inputString);
	for(i=0;i<len;i++){
		if(inputString[i]>='0'&&inputString[i]<='9') return inputString[i];
	}
	return 0;
}

int main() {
	char* inp = "var_1__Int";
	printf("%c\n",firstDigit(inp));
	
	return 0;
}


