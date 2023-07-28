package Island_of_Knowledge;

public class Island_of_Knowledge_6_minesweeper {

	int[][] minesweeper(boolean[][] matrix) {
	    int[][] output = new int[matrix.length][matrix[0].length];
	    for(int i=0;i<matrix.length;i++){
	        for(int j=0;j<matrix[0].length;j++){
	            if(matrix[i][j]) {
	                for(int k=i-1;k<=i+1;k++){
	                    for(int l=j-1;l<=j+1;l++){
	                        if(k>=0&&k<=output.length-1&&j>=0&&j<=output[0].length){
	                            if(k!=i&&l!=j) output[k][l]++;
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
