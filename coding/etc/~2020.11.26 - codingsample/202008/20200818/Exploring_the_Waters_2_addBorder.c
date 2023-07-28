#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct arr_string {
	int size;
	char **arr;
} arr_string;

arr_string alloc_arr_string(int len) {
	arr_string a = {len, len > 0 ? malloc(sizeof(char*) * len) : NULL};
	return a;
}



arr_string addBorder(arr_string picture) {
    int new_str_len = strlen(picture.arr[0])+2;
    int new_str_size = picture.size + 2;
    arr_string str_border = alloc_arr_string(new_str_size);
	int i;
    for(i=0; i<new_str_size; i++){
        str_border.arr[i] = (char*) malloc(sizeof(char)*(new_str_len+1));
        if(i==0 || i==new_str_size-1){
            memset(str_border.arr[i],'*',new_str_len);
        }
        else{
           sprintf(str_border.arr[i], "*%s*", picture.arr[i-1]);
        }
    }
    
    return str_border;
}

arr_string addBorder2(arr_string picture) {
	int len = strlen(picture.arr[0])+2,i;
	int size = picture.size+2;
	arr_string output = alloc_arr_string(size);
	for(i=0;i<size;i++){
		output.arr[i] = (char*)malloc(len+1);
		if(i==0||i==size-1) memset(output.arr[i],'*',len);
		else sprintf(output.arr[i],"*%s*",picture.arr[i-1]);
	}
    return output;
}


int main() {
	arr_string a = alloc_arr_string(2);
	int i;
	for(i=0;i<a.size;i++) a.arr[i] = (char*)malloc(sizeof(char)*3);
	a.arr[0] = "abc";
	a.arr[1] = "def";
	arr_string out = alloc_arr_string(a.size+2);
	out = addBorder2(a);
	for(i=0;i<out.size;i++) printf("%s\n",out.arr[i]);
}


