#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool palindromeRearranging(char * inputString) {
	int asc[127]={0,};
	int len = strlen(inputString),i;
	bool err1 = false;
	for(i=0;i<len;i++) asc[inputString[i]]++;
	for(i=0;i<127;i++){
		if(asc[i]%2!=0){
			if(err1) return false;
			else err1=true;
		} 
	}
	return true;
}

int main() {
	char *input = "aabbbbgggeee";
	if(palindromeRearranging(input)) printf("True\n");
	else printf("False\n");
}


