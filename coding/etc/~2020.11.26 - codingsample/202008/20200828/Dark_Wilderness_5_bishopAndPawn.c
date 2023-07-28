#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool bishopAndPawn(char * bishop, char * pawn) {
    return abs(bishop[0]-pawn[0]) == abs(bishop[1]-pawn[1]);
}

int main(void){
    if(bishopAndPawn("a1","c3")) printf("True\n");
    else printf("False\n");
    return 0;
}