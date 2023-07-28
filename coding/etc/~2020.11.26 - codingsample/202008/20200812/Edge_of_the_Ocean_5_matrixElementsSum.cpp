#include <stdio.h>
// 2차원 배열상에서 0밑에있는 수를 제외한 모든 수를 더하는 값을 반환하는 함수 
int matrixElementsSum(int matrix[][4],int size,int matsize) {
    int Cut[size];
    for(int i=0;i<size;i++)  Cut[i]=0;
    int CutNum=0, sum=0;
    for(int i=0;i<matsize;i++){
        for(int j=0;j<size;j++){
            if(Cut[j]==0) sum+=matrix[i][j];
            if(matrix[i][j]==0) Cut[j]=1;
        }
    }
    return sum;
}

int main() {
	int a[3][4] = {
		{0,1,1,2},
		{0,5,0,0},
		{2,0,3,3},
	};
	int size = sizeof(a[0])/sizeof(int);
	int matsize = sizeof(a)/(sizeof(int)*size);
	int var = matrixElementsSum(a,size,matsize);
	printf("%d\n",var);
	return 0;
}
