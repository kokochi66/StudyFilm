#include <stdio.h>
#include <stdlib.h>
//배열에서 -1위치를 제외한 나머지를 크기 순서로 정렬하는 함수 
typedef struct arr_integer {
	int size;
	int *arr;
} arr_integer;
arr_integer alloc_arr_integer(int len);
arr_integer sortByHeight(arr_integer a);
void quickSort(int *arr,int left, int right);

int main() {
	arr_integer a = alloc_arr_integer(8);
	int arr[8] = {-1,150,190,170,-1,-1,160,180};
	a.arr = &arr;
	sortByHeight(a);
	int i;
	for(i=0;i<a.size;i++) printf("%d ",a.arr[i]);
}

void quickSort(int *arr,int left, int right){
	int i=left, j=right;
	int pivot = arr[(left+right)/2];
	int temp;
	do {
		while(arr[i]<pivot) i++;
		while(arr[j]>pivot) j--;
		if(i<=j){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}while(i<=j);
	if(left<j) quickSort(arr,left,j);
	if(i<right) quickSort(arr,i,right);
}
arr_integer sortByHeight(arr_integer a) {
	arr_integer b = alloc_arr_integer(a.size);
	int bNum=0;
	int i=0;
	for(i=0;i<a.size;i++){
		if(a.arr[i]!=-1) {
			b.arr[bNum]=a.arr[i];
			bNum++;
		}
	}
	quickSort(b.arr,0,bNum-1);
	bNum=0;
	for(i=0;i<a.size;i++){
		if(a.arr[i]!=-1) {
			a.arr[i]=b.arr[bNum];
			bNum++;
		}
	}
	return a;
}
// 나의 답안
arr_integer sortByHeight(arr_integer a) {
    for (int i = 0; i < a.size - 1; i++) {
        if (-1 == a.arr[i])
            continue;
        for (int j = i + 1; j < a.size; j++) {
            if (-1 == a.arr[j])
                continue;
            if (a.arr[i] > a.arr[j]) {
                int temp = a.arr[j];
                a.arr[j] = a.arr[i];
                a.arr[i] = temp;
            }            
        }
    }
    return a;
}
// 모범 답안

arr_integer alloc_arr_integer(int len){
	arr_integer a = {len, len > 0 ? malloc(sizeof(int)*len):NULL};
	return a;
}

