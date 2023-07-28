#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

 typedef struct arr_string {
   int size;
   char **arr;
 } arr_string;

arr_string alloc_arr_string(int len) {
   arr_string a = {len, len > 0 ? malloc(sizeof(char*) * len) : NULL};
   return a;
 }
arr_string insertstring(arr_string a, char b[][4]){
	int i;
	for(i=0;i<a.size;i++) {
		a.arr[i] = (char) malloc(sizeof(char)*strlen(b[i]));
		a.arr[i] = b[i];
	}
	return a;
}

bool checkkochi3(arr_string a,bool swit[],int point){
	int i,j,k,len=strlen(a.arr[0]);
	swit[point]=true;
	int err;
	for(i=0;i<a.size;i++){
		if(swit[i]==false){
			for(j=0;j<a.size;j++){
				if(swit[j]==false){
					err=0;
					for(k=0;k<len;k++){
						if(a.arr[j][k]!=a.arr[point][k]) err++;
						if(err>=2) break;
					}
					if(err==1) {
                        printf("재귀작동 %d\n",j);
                        if(checkkochi3(a,swit,j)) {
						    printf("함수 정상작동성공\n");
						    return true;
                        }
					}
				}
			}
			swit[point]=false;
			printf("해당사항없음\n");
			return false;
		}
	}
	printf("모든 항목이 true\n");
	return true;
}

bool stringsRearrangement(arr_string a) {
    bool swit[a.size];
    int i;
    for(i=1;i<a.size;i++) swit[i] = false;
    swit[0]=true;
    for(i=0;i<a.size;i++) if(checkkochi3(a,swit,i)) return true;
    return false;
}


int main() {
	char b[3][4] = {"aba","bbb","bab"};
	arr_string a = alloc_arr_string(3);
	a = insertstring(a,b);
	if(stringsRearrangement(a)) printf("True\n");
	else printf("False\n");
	return 0;
}


