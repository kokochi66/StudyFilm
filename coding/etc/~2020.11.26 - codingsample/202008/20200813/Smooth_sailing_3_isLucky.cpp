#include <stdio.h>
//정수가 주어졌을때, 앞 절반과 뒷 절반의 합이 같으면 true, 아니면 false를 반환 
bool isLucky(int n) {
	int temp=0, var=n;
	while(var>0) {
		var/=10;
		temp++;
	}
	int sumA=0;
	int sumB=0;
	for(int i=1;i<=temp;i++){
		if(i<=temp/2) sumA+=n%10;
		else sumB+=n%10;
		n/=10;
	}
	return sumA==sumB;
}
//나의 답안 


int main() {
	int a = 1230;
	int b = 239017;
	if(isLucky(b)) printf("True\n");
	else printf("False\n");
} 
