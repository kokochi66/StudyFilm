//괄호 안에있는 문자열만을 역으로 출력 
char* extra(char *input,int left,int right){
    int i,len=strlen(input);
    if(left>right) {
        input[0] = '\0';
        return input;
    }
    for(i=left;i<=right;i++){
        input[i-left] = input[i];
        if(i==right) input[i-left+1] = '\0'; 
    }
    return input;
}

char* revstr(char *input){
    int i,len=strlen(input);
    char temp;
    for(i=0;i<len/2;i++){
        temp = input[i];
        input[i] = input[len-i-1];
        input[len-i-1] = temp;
    }
    return input;
}

char* reverseInParentheses(char *inputString) {
    int len = strlen(inputString),i,left;
    char* temp1 = malloc(sizeof(char)*len);
    char* output = malloc(sizeof(char)*len);
    strcpy(temp1,inputString);
    for(i=0;i<len;i++){
        if(inputString[i]=='(') left=i;
        else if(inputString[i]==')'){
            strcat(output,extra(temp1,0,left-1));
            strcpy(temp1,inputString);
            strcat(output,revstr(extra(temp1,left+1,i-1)));
            strcpy(temp1,inputString);
            strcat(output,extra(temp1,i+1,len-1));
            return reverseInParentheses(output);
        }
    }
    return inputString;
}

