#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
    int height = upSpeed, count = 1;
    while(height<desiredHeight){
        height+=(upSpeed-downSpeed);
        count++;
    }
    return count;
}

int growingPlant2(int upSpeed, int downSpeed, int desiredHeight) {
    float r = ((desiredHeight - downSpeed)/(float)(upSpeed - downSpeed));
    int res = (int)r;
    if (r > res) { res++; }
    return res < 0 ? 1 : res;
}

int main(void){
    printf("%d\n",growingPlant(100,10,910));
    return 0;
}