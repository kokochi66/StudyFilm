#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

bool variableName(char * name) {
	int i=0,len = strlen(name);
	// 변수 초기화
	 
	for(i=0;i<len;i++){		
		if((isalnum(name[i]) || name[i]=='_') == false || isdigit(name[0])) return false;
	}
	return true;
}



int main() {
	char* input = "var_1__Int";
	if(variableName(input)) printf("True\n");
	else printf("False;");
}


