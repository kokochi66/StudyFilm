import java.util.*;

public class pro_Level2_8 {
    public static int square(long[][] picture, int x, int y, long n){
        if(x<0||y<0||x>=picture.length||y>=picture[0].length||picture[x][y]!=n) return 0;
        int sum = 1;
        picture[(int)x][(int)y] = -1;
        sum += square(picture,x+1,y,n)+square(picture,x-1,y,n);
        sum += square(picture,x,y+1,n)+square(picture,x,y-1,n);
        return sum;
    }
    public static int[] solution(int m, int n, int[][] picture) {
        HashSet<Long> Colors = new HashSet<Long>();
        long[][] pictureTemp = new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pictureTemp[i][j] = picture[i][j];
            }
        }
        int max = 0;
        for(int i=0;i<pictureTemp.length;i++){
            for(int j=0;j<pictureTemp[0].length;j++){
                if(pictureTemp[i][j] != -1) Colors.add(pictureTemp[i][j]);
                int temp;
                if(pictureTemp[i][j]>0) {
                    temp = square(pictureTemp,i,j,pictureTemp[i][j]);
                    if(max<temp) max=temp;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = Colors.size();
        answer[1] = max;
        return answer;
    }
    public static void test(int[] n){
        Arrays.sort(n);
    }
    public static void main(String[] args){
        int[][] a = {
            {2147483647,2147483647,2147483647,1},
            {2147483647,2,2,1},
            {2147483647,0,1,1},
            {2147483647,1,0,1},
            {1,0,0,3},
            {0,0,0,3}
        };
        System.out.println(Arrays.toString(solution(6,4,a)));
    }
}
