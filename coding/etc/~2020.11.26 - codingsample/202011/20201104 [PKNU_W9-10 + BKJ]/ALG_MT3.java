import java.util.Arrays;

public class ALG_MT3 {
    // 알고리즘 3장 동적 계획

    public static void main(String[] args){
        int[][] arr = {
            {0,1,999,1,5},
            {9,0,3,2,999},
            {999,999,0,4,999},
            {999,999,2,0,3},
            {3,999,999,999,0}
        };
        int[][] output = Num1_Floyd(arr);
        for(int i=0;i<arr.length;i++) System.out.println(Arrays.toString(output[i]));

    }

    public static int[][] Num2_Opt(){
        int[][] output = new int[1][1];
        return output;
    }
    public static int[][] Num1_Floyd(int[][] weight) {
        int n = weight.length;
        int[][] output = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                output[i][j] = weight[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(output[i][k]+output[k][j] < output[i][j]){
                        output[i][j] = output[i][k]+output[k][j];
                    }
                }
            }
        }
        return output;
    }
}
