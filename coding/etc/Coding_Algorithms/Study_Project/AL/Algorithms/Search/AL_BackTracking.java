package Algorithms.Search;
import java.util.*;
import java.io.*;

public class AL_BackTracking {
	public static void main(String[] args) {
		int n = 4;
		int[] a = {1,2,3,4};
		int[] tar = new int[n];
		boolean[] chk = new boolean[n];
		BTK(n, 0, a, tar, chk);
	}
	
	public static void BTK(int m, int k, int[] arr, int[] tar, boolean[] chk) {
		if(m == k) {
			System.out.println(Arrays.toString(tar));
		} else {
			for(int i=0;i<arr.length;i++) {
				if(!chk[i]) {
					tar[k] = arr[i];
					chk[i] = true;
					BTK(m, k+1, arr, tar, chk);
					chk[i] = false;
				}
			}
		}
	}
}
