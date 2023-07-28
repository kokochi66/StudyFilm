#include <stdio.h>

//마름모 모양의 정사각형을 1씩 키워나감 
int shapeArea(int n) {
    int sum=1;
    for(int i=0;i<n;i++){
        sum+=i*4;
    }
    return sum;
}

int shapeArea2(int n) {
    return (n * n + (n - 1) * (n - 1));
}

int main() {
	printf("%d",shapeArea2(8));
}
// 1 2 3  4  5  6  7  8
// 1 5 13 25 41 61 85 113
// 4 8 12 16 20 24 28
