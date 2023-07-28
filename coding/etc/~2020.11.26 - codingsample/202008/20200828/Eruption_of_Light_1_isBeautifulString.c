#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool isBeautifulString(char * inputString) {
    int check['z'-'a'+1] = {0,};
    int i,len=strlen(inputString);
    for(i=0;i<len;i++) check[inputString[i]-'a']+=1;
    for(i=1;i<'z'-'a'+1;i++) {
        if(check[i-1]<check[i]) return false;
        // printf("%d %d\n",check[i-1],check[i]);
    }
    return true;
}

int main(void) {
    if(isBeautifulString("aabbb")) printf("True\n");
    else printf("False\n");
}
