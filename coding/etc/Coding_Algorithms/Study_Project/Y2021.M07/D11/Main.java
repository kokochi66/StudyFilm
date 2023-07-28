package D11;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		System.out.println(solution(1000000000, new int[] {7,9,12,13,5,13,589,23,8654,2138,321,845,1,54,6352,1,546,1231231,9,99,99,21328564,2123523,215472,216823,965321,17774745,12131}));
//		System.out.println(solution(6, new int[] {7,10}));
	}
    public static long solution(int n, int[] times) {
    	Arrays.sort(times);
    	int m = times.length;
    	long min = 0, max = (long)1000000000 * (long)1000000000;
    	long mid = max;
    	while(!isMin(mid, times, m, n)) {
//    		if(min >= max) break;
    		if(sum >= n) {
    			max = mid;
    			mid = (min + max) / 2;
    		} else {
    			min = mid;
    			mid = ((min + max) / 2) + 1;
    		}
    	}
        return mid;
    }
    static long sum=0;
    public static boolean isMin(long mid, int[] times, int m, int n) {
    	sum = 0;
    	boolean oneClear = false;
    	for(int i=0;i<m;i++) {
    		sum += Math.floor(mid / times[i]);
    		if(mid % times[i] == 0) oneClear = true;
    	}
    	if(oneClear && sum >= n) {
    		sum = 0;
    		long submid = mid-1;
    		oneClear = false;
        	for(int i=0;i<m;i++) {
        		sum += Math.floor(submid / times[i]);
        		if(submid % times[i] == 0) oneClear = true;
        	}
        	if(sum < n) return true;
    	}
    	return false;
    }
}