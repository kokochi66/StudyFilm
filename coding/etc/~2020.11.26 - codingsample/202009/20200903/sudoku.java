import java.util.Arrays;

public class sudoku {
    //입력된 정수 2차원배열이 스도쿠로써, 모든 3x3배열이 1부터 9까지 차있고, 모든 가로세로가 1부터 9까지 차있는지를 검사하는 함수
    //1차 체크에서는 모든 가로세로를 검사한다.(2중 반복문으로 구현하면 간단하게 가능할듯)
    //2차체크인 모든 3x3배열을 검사하는 방법은 정수배열 temp를 만든 후에, 각 3x3배열의 값들을 temp에 1부터 9까지 펼친 뒤에 별도의 함수로 넘기는 방식이 편할듯
    static boolean check(int[] a){
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        for(int i=0;i<a.length;i++) if(i+1 != a[i]) return false;
        return true;
    }
    static boolean sudoku(int[][] grid) {
        int[] temp = new int[9];
        for(int i=0;i<9;i++){
            //가로검사
            for(int j=0;j<9;j++) temp[j] = grid[i][j];
            if(!check(temp)) {
                System.out.println("가로검사 불통 " + i);
                return false;
            }
            //세로검사
            for(int j=0;j<9;j++) temp[j] = grid[j][i];
            if(!check(temp)) {
                System.out.println("세로검사 불통 " + i);
                return false;
            }
        }
        int count = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                count = 0;
                for(int k=i*3;k<(i+1)*3;k++){
                    for(int l=j*3;l<(j+1)*3;l++){
                        temp[count++] = grid[k][l];
                    }
                }
                if(!check(temp)) {
                    System.out.println("3x3검사 불통");
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        int[][] grid = {{1, 3, 2, 5, 4, 6, 9, 8, 7},
                        {4, 6, 5, 8, 7, 9, 3, 2, 1},
                        {7, 9, 8, 2, 1, 3, 6, 5, 4},
                        {9, 2, 1, 4, 3, 5, 8, 7, 6},
                        {3, 5, 4, 7, 6, 8, 2, 1, 9},
                        {6, 8, 7, 1, 9, 2, 5, 4, 3},
                        {5, 7, 6, 9, 8, 1, 4, 3, 2},
                        {2, 4, 3, 6, 5, 7, 1, 9, 8},
                        {8, 1, 9, 3, 2, 4, 7, 6, 5}};
        System.out.println(sudoku(grid));
    }
    
}
