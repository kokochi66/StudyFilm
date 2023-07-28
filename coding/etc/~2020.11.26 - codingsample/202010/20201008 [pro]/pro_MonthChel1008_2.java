import java.util.Arrays;

public class pro_MonthChel1008_2 {

    public static int[] sumS(int[][] arr, int sum, int x, int y, int n){
        int[] output = new int[2];
        Arrays.fill(output, 0);
        if(n > 2){
            int[] a1 = new int[2];
            int[] a2 = new int[2];
            int[] a3 = new int[2];
            int[] a4 = new int[2];
            a1 = sumS(arr,sum,x,y,n/2);
            a2 = sumS(arr,sum,x+(n/2),y,n/2);
            a3 = sumS(arr,sum,x,y+(n/2),n/2);
            a4 = sumS(arr,sum,x+(n/2),y+(n/2),n/2);
            if(a1[0]==1&&a1[1]==0&&a2[0]==1&&a2[1]==0&&a3[0]==1&&a3[1]==0&&a4[0]==1&&a4[1]==0) output[0] = 1;
            else output[0] = a1[0]+a2[0]+a3[0]+a4[0];
            if(a1[0]==0&&a1[1]==1&&a2[0]==0&&a2[1]==1&&a3[0]==0&&a3[1]==1&&a4[0]==0&&a4[1]==1) output[1] = 1;
            else output[1] = a1[1]+a2[1]+a3[1]+a4[1];
            return output;
        }
        else {
            int TempSum = arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x+1][y+1];
            // System.out.println(x+" "+y);
            // System.out.println("SUM :: ="+TempSum);
            if(TempSum == 0) {
                output[0] = 1;
                output[1] = 0;
                return output;
            }
            else if(TempSum == 4) {
                output[0] = 0;
                output[1] = 1;
                return output;
            }
            else {
                output[0] = 4-TempSum;
                output[1] = TempSum;
                return output;
            }
        }
    }
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        return sumS(arr,0,0,0,arr.length);
    }
    public static void main(String[] args){
        int[][] a = 
        {{1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1},
        {0,0,0,0,1,1,1,1},
        {0,1,0,0,1,1,1,1},
        {0,0,0,0,0,0,1,1},
        {0,0,0,0,0,0,0,1},
        {0,0,0,0,1,0,0,1},
        {0,0,0,0,1,1,1,1}};


        int[][] b = {
            {1,1,0,0},
            {1,0,0,0},
            {1,0,0,1},
            {1,1,1,1}
        };
        System.out.println(solution(a));
    }
}
