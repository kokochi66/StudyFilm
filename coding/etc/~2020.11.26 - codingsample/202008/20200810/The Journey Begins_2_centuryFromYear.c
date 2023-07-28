#include <stdio.h>

int centuryFromYear(int year) {
	return 1+(year-1)/100;
}

int main(){
	printf("%d",centuryFromYear(2400));

}
