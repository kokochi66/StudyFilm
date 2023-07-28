#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h> 

bool chessBoardCellColor(char * cell1, char * cell2) {
    return ((((cell1[0]-'A')%2)==(cell1[1]%2))==(((cell2[0]-'A')%2)==(cell2[1]%2)));
}


int main() {
	char* ce1 = "A1";
	char* ce2 = "C3";
	if(chessBoardCellColor(ce1,ce2)) printf("True\n");
	else printf("False\n");
}


