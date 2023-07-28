#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

char * findEmailDomain(char * address) {
    int i,j, len = strlen(address);
    char *output = (char*) malloc(len);
    for(i=len-1;i>=0;i--){
        if(address[i] == '@'){
                for(j=i+1;j<len;j++){
                    output[j-i-1] = address[j];
                    if(j==len-1) output[j-i] = '\0';
                }
            break;
        }
    }
    return output;
}

int main(void) {
    printf("%s\n",findEmailDomain("\"much.more unusual\"@yahoo.com"));
    return 0;
}
