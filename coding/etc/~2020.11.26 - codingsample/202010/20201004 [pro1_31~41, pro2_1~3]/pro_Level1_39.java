public class pro_Level1_39 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] map1 = new boolean[n][n];
        boolean[][] map2 = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((arr1[i] & (int)Math.pow(2,j)) == (int)Math.pow(2,j)) map1[i][n-j-1] = true;
                else map1[i][n-j-1] = false;
                if((arr2[i] & (int)Math.pow(2,j)) == (int)Math.pow(2,j)) map2[i][n-j-1] = true;
                else map2[i][n-j-1] = false;
            }
        }
        String[] output = new String[n];
        for(int i=0;i<n;i++){
            output[i] = "";
            for(int j=0;j<n;j++){
                if(map1[i][j] || map2[i][j]) output[i] +="#";
                else output[i] +=" ";
            }
        }
        return output;
    }
}
