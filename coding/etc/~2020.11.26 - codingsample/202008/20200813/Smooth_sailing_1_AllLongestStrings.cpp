#include <stdio.h>
//문자열 배열의 가장 긴 문자열의 배열만을 남기는 함수 
//C언어 자체적 문제로 별도의 구조체를 이용한 방법을 사용
// Arrays are already defined with this interface:
// typedef struct arr_##name {
//   int size;
//   type *arr;
// } arr_##name;
//
// arr_##name alloc_arr_##name(int len) {
//   arr_##name a = {len, len > 0 ? malloc(sizeof(type) * len) : NULL};
//   return a;
// }
//
// 
arr_string allLongestStrings(arr_string inputArray) {
    int max = 0, over=0, var=0;
    while(over<inputArray.size){
        printf("throgh %s %d\n", inputArray.arr[over], strlen(inputArray.arr[over]));
        if(max<strlen(inputArray.arr[over])){
            printf("max over %s\n",inputArray.arr[over]);
            max=strlen(inputArray.arr[over]);
            var=0;
            for(int i=over;i<inputArray.size;i++){
                inputArray.arr[var]=inputArray.arr[i];
                var++;
            }
            inputArray.size-=over;
            over=0;
        }
        else if(max>strlen(inputArray.arr[over])) {
            printf("small delete %s\n",inputArray.arr[over]);
            for(int i=over;i<inputArray.size-1;i++){
                inputArray.arr[i]=inputArray.arr[i+1];
            }
            inputArray.size-=1;
            over--;
        }
        over++;
    }
    return inputArray;
}
// 나의 답안
arr_string allLongestStrings(arr_string inputArray) {
    arr_string res=alloc_arr_string(inputArray.size);
    int i,j=0,max=0;
    for(i=0;i<inputArray.size;i++)
        if(max<strlen(inputArray.arr[i])) max=strlen(inputArray.arr[i]);
    for(i=0;i<inputArray.size;i++)
        if(strlen(inputArray.arr[i])==max) {
            res.arr[j++]=inputArray.arr[i];
        }
    res.size=j;
    return res;
}
// 모범 답안
//체크해야 할 부분
//나는 기존에 있던 inputArray를 그대로 유지한 채로, 배열의 개수를 줄이는 방안을 선택하였지만,
//새로운 배열을 할당하여 그 배열에 조건에 만족하는 값을 추가하는 방식이 코딩이 더 간단하게 이루어질 수 있음. 
 
