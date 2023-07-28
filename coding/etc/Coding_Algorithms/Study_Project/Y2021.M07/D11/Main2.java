package D11;
import java.util.*;
import java.io.*;
public class Main2 {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		System.out.println(solution(5, new int[][]{{4,3}, {4,2},{3,2},{1,2},{2,5}}));
//		System.out.println(solution(5, new int[][]{{1,2}, {1,5},{2,4},{4,3},{5,4}}));
	}
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int m = results.length;
        
        int[][] map = new int[n][n];
        // 1 = up, 2 = down, 0 = X
        
        for(int i=0;i<m;i++) {
        	int up = results[i][0]-1;
        	int down = results[i][1]-1;
        	map[up][down] = 2;
        	map[down][up] = 1;
        }
        
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(map[i][j] > 0) {
            		for(int k=0;k<n;k++) {
            			if(map[i][j] == map[j][k]) {
            				map[i][k] = map[i][j];
            			}
            		}
        		}

        	}
        }
        
        for(int i=0;i<n;i++) {
        	int cnt = 0;
        	for(int j=0;j<n;j++) {
        		if(map[i][j] > 0) cnt++;
        	}
        	if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}