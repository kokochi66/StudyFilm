#include <stdio.h>

//배열의 인접한 값들의 곱중 가장 큰 값을출력하는 함수 
int adjacentElementsProduct(int inputArray[]){
	int sum=inputArray[0]*inputArray[1];
    for(int i=1;i<sizeof(inputArray)-1;i++){
    	if(inputArray[i]*inputArray[i+1]>sum) sum=inputArray[i]*inputArray[i+1];
    }
    return sum; 
}
int main() {
	int arr[10] = {2,7,10,5,-2,6,22,1,-4,55};
	printf("%d",adjacentElementsProduct(arr));
}

