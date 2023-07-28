import java.util.Arrays;

public class spiralNumbers {
    // n*n 크기의 정사각형 배열을 1,2,3,4,5 순서대로 시계방향으로 채워나가는 배열을 반환하는 함수
    // 방법 : x와 y 현재좌표를 설정한 뒤에, y+, x+, y-, x- 순서대로 회전하는 방식을 선정 -> 4가지 방식이 있기 때문에 boolean[2] 로 방식을 정함.
    // 00 x+ 01 y+ 11 x- 10 y- 순서대로 정함.
    // boolean[2] rotation = f,f로 초기화, 정사각형 배열이기 때문에 while(output[x][y]==0) 으로 반복, output은 선언 후 모두 0으로 초기화함. 
    // 다음으로 이어가는 곳이 막혀있는지를 따지는 boolean 함수를 만듦. 막혀있다면 boolean을 다음 값으로 세팅해줌.
    static int[][] spiralNumbers(int n) {
        int[][] output = new int[n][n];
        boolean[] rotation = new boolean[2];
        Arrays.fill(rotation,false);                    // rotation을 f,f로 초기화
        for(int i=0;i<n;i++) Arrays.fill(output[i],0);  // 출력 배열을 0으로 모두 초기화
        int x=0, y=0, CountVar=1;
        int mCount = 5;
        while(output[x][y]==0){
            output[x][y] = CountVar++;
            if(!rotation[0]&&!rotation[1]) {
                if((n-(mCount/4))==y) {
                    rotation[0] = true;
                    mCount++;
                    x++;
                }
                else y++;
            }
            else if(rotation[0]&&!rotation[1]) {
                if((n-(mCount/4))==x) {
                    rotation[1] = true;
                    mCount++;
                    y--;
                }
                else x++;
            }
            else if(rotation[0]&&rotation[1]) {
                if((mCount/4)-1==y) {
                    rotation[0] = false;
                    mCount++;
                    x--;
                }
                else y--;
            }
            else {
                if((mCount/4)-1==x) {
                    rotation[1] = false;
                    mCount++;
                    y++;
                }
                else x--;
            }
        }
        return output;
    }

    public static void main(String[] args){
        int n = 3;
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(spiralNumbers(n)[i]));
    }
    
}
