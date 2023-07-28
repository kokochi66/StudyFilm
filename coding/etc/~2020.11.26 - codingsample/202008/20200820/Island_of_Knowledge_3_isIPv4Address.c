#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

bool isIPv4Address(char *inputString) {
	int i,count=0,temp=0;
	for(i=0;i<strlen(inputString);i++){
		if(inputString[i]=='.') {
			if(i==0||i==strlen(inputString)-1) {
				printf("사유1. 시작이나 끝에 .이 들어감(특수조건)\n");
				return false;	//특수조건처리
			}
			else if(temp==0&&inputString[i-1]!='0') {
				printf("사유2. temp가 조건에 맞지 않음(temp가 비었거나, 예정된 수치보다 높음)\n");
				return false;
			}
			count++;
			temp=0;
		}
		else {
			if(inputString[i]-48<0||inputString[i]-48>9) {
				printf("사유4. 숫자가 아님\n");
				return false; 
			}
			else if(inputString[i]-48==0) {
				if(i!=strlen(inputString)-1) if(inputString[i+1]!='.') return false;
				if(i!=0) if(inputString[i-1]!='.') return false;
			}
			else {
				temp*=10;
				temp+=inputString[i]-48;
				if(temp>255){
					printf("사유2. temp가 조건에 맞지 않음(temp가 비었거나, 예정된 수치보다 높음)\n");
					return false;
				}
			}
		}
	}
	if(count!=3) {
		printf("사유5. 점의 개수가 맞지 않음\n");
		return false;
	}
	return true;
}


int main() {
	char input[50] = "01.233.161.131";
	if(isIPv4Address(input)) printf("True\n");
	else printf("False\n");
	
	
}


