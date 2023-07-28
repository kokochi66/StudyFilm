import java.util.Arrays;

public class pro_Level2_10 {
    public static int[] solution(int n) {
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(matrix[i], 0);
        boolean check = true;
        boolean[] direction = new boolean[2];
        Arrays.fill(direction, false);
        // 00 = 아래, 01 = 오른쪽, 11 = 왼쪽위
        int CurrX = 0, CurrY = 0, CurrP = 1;
        matrix[CurrX][CurrY] = CurrP++;
        if(n==1) check = false;
        while(check){
            if(!direction[0] && !direction[1]) { //00
                CurrX+=1;
                if(CurrX+1 == n || matrix[CurrX+1][CurrY] != 0) {
                    direction[1]=true;
                    if(CurrY+1 == n || matrix[CurrX][CurrY+1] != 0) check = false;
                }
            }
            else if(!direction[0] && direction[1]) { //01
                CurrY+=1;
                if(CurrY+1 == n || matrix[CurrX][CurrY+1] != 0) {
                    direction[0]=true;
                    if(matrix[CurrX-1][CurrY-1] != 0) check = false;
                }
                
            }
            else if(direction[0] && direction[1]) { //11
                CurrX-=1;
                CurrY-=1;
                if(matrix[CurrX-1][CurrY-1] != 0) {
                    Arrays.fill(direction, false);
                    if(CurrX+1 == n || matrix[CurrX+1][CurrY] != 0) check = false;
                }
            }
            matrix[CurrX][CurrY] = CurrP++;
        }
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(matrix[i]));
        int[] answer = new int[CurrP-1];
        int answerNum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] != 0) answer[answerNum++] = matrix[i][j];
                else break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(2)));
    }
}
