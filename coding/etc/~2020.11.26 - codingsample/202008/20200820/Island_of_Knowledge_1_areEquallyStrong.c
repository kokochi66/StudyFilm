#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
	if(yourLeft!=friendsLeft&&yourLeft!=friendsRight) return false;
	else if(yourRight!=friendsLeft&&yourRight!=friendsRight) return false;
	return true;
}

int main() {
	int a1 = 10, a2 = 20, b1=20, b2=11;
	if(areEquallyStrong(a1,a2,b1,b2)) printf("True\n");
	else printf("False\n");
}


