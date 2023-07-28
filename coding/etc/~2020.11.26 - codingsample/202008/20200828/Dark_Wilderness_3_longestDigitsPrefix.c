#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *longestDigitsPrefix(char *inputString) {
    int i,len = strlen(inputString);
    char *output = malloc(len);
    int outputNum = 0;
    for(i=0;i<len;i++){
        if(inputString[i]>='0'&&inputString[i]<='9') {
            output[outputNum++] = inputString[i];
            output[outputNum] = '\0';
        }
        else if(outputNum != 0) return output;
    }
    return output;
}

int main(void){
    char *in = "123aa1";
    printf("%s\n",longestDigitsPrefix(in));
    return 0;
}