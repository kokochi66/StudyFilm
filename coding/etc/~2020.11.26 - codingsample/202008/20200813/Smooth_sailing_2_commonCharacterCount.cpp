#include <stdio.h>
//두 문자열이 주어졌을때, 두 문자열에서 공통 문자수를 반환하는 함수 
int commonCharacterCount(char * s1, char * s2) {
	int s1_size , s2_size;
	int empty[100] = {0,};
	int output=0;
	
	for(int i=0;s1[i]!='\0';i++){
		for(int j=0;s2[j]!='\0';j++){
			if(s1[i]==s2[j] && empty[j]==0) {
				output++;
				empty[j]=1;
				break;
			}
		}
	}
	return output;
}
//나의 답안 

int commonCharacterCount2(char * s1, char * s2) {
    int count = 0;
    for(int i = 0; i < strlen(s1); i++){
        for(int j = 0; j < strlen(s2); j++){
            if(s1[i] == s2[j]){
                s1[i] = '#';
                s2[j] = '#';
                count++;
                break;
            }
        }
    }
    return count;
}
//모범답안
//포인트
//문자열 자체에서 걸러버리면 empty같은거 생성안해줘도되는구나 

int main() {
	char a[10] = "aabcc";
	char b[6] = "adcaa";
	int c = commonCharacterCount(a,b);
	printf("%d\n",c);
} 
