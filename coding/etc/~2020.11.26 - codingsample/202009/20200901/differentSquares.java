package javaSpeedCoding20200901;

import java.util.Arrays;

public class differentSquares {
	static boolean CompSquares(int[][] m, int x1,int y1,int x2,int y2) {	//?? 2x2?? ???? ???????? ?????? ???(??)
		return !(m[x1][y1]!=m[x2][y2]||m[x1+1][y1]!=m[x2+1][y2]||m[x1][y1+1]!=m[x2][y2+1]||m[x1+1][y1+1]!=m[x2+1][y2+1]);
	}
	
	static int SumSquares(int[][] m, int x,int y) {	//2x2?? ???? ?????? ???
		return m[x][y]+m[x+1][y]+m[x][y+1]+m[x+1][y+1];
	}
	static int differentSquares(int[][] m) {	//2???? ?��???? ?? 2x2?? ?????? ??????? ?????? ?????? ???
		boolean[][] check = new boolean[m.length][m[0].length];
		for(int i=0;i<check.length;i++) Arrays.fill(check[i], Boolean.FALSE);
		int count = 0;
		for(int i=0;i<m.length-1;i++) {
			for(int j=0;j<m[0].length-1;j++) {
				System.out.println(i + " " + j);
				if(!check[i][j]) {
					check[i][j] = true;
					count++;
					for(int k=i;k<m.length-1;k++) {
						for(int l=0;l<m[0].length-1;l++) {
							if(CompSquares(m,i,j,k,l)) check[k][l] = true;
						}
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[][] a = {{2,5,3,4,3,1,3,2}, 
		             {4,5,4,1,2,4,1,3}, 
		             {1,1,2,1,4,1,1,5}, 
		             {1,3,4,2,3,4,2,4}, 
		             {1,5,5,2,1,3,1,1}, 
		             {1,2,3,3,5,1,2,4}, 
		             {3,1,4,4,4,1,5,5}, 
		             {5,1,3,3,1,5,3,5}, 
		             {5,4,4,3,5,4,4,4}};
		System.out.println(differentSquares(a));
	}

}
