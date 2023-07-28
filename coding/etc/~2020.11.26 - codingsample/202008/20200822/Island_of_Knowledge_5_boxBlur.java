package Island_of_Knowledge;

public class Island_of_Knowledge_4_boxBlur {
	
	int[][] boxBlur(int[][] image) {
	    int[][] output = new int[image.length-2][image[0].length-2];
	    for(int i=0;i<output.length;i++){
	        for(int j=0;j<output[0].length;j++){
	            output[i][j] = 0;
	            for(int k=i;k<=i+2;k++){
	                for(int l=j;l<=j+2;l++){
	                    output[i][j]+=image[k][l];
	                }
	            }
	            output[i][j]/=9;
	        }
	    }
	    return output;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
