#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int differentSymbolsNaive(char *s) {
	int check['z'-'a'+1] = {0,};
	int i,len=strlen(s),output=0;
	for(i=0;i<len;i++) {
		if(check[s[i]-'a'] == 0) output++;
		check[s[i]-'a'] = 1;
	}
	return output;
}


int main() {
	char *a = "cabac";
	printf("%d\n",differentSymbolsNaive(a));
	return 0;
}


