package D28;

import java.util.*;
import java.io.*;
public class Solution {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		String[] a = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] b = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		solution(6,6,b);
	}
	public static int solution(int m, int n, String[] board) {
        int ch =0, cw = 0;
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        char[][] darr = new char[m][n];
        for(int i=0;i<m;i++) darr[i] = board[i].toCharArray();
        for(int i=0;i<n;i++) {
        	list.add(new ArrayList<Character>());
        	for(int j=m-1;j>=0;j--) list.get(i).add(darr[j][i]);
        }
        int count = 0;
        boolean pass = true;
        do {
        	pass= false;
        	char ctb = '1';
        	for(int i=0;i<list.size()-1;i++) {
        		for(int j=0;j<list.get(i).size()-1;j++) {
        			if(list.get(i).get(j) != 'Z') {
        				if(check(list,i,j,list.get(i).get(j), ctb)) {
        					for(int t=0;t<m;t++) {
        			        	for(char a : list.get(t)) System.out.print(a+" ");
        			        	System.out.println();
        			        }
        					System.out.println();
        					for(int q=0;q<list.size();q++) {
        						while(list.get(q).contains(ctb)) {
        							list.get(q).remove(list.get(q).indexOf(ctb));
        							count++;
        						}
        					}
        					ctb++;
        					pass = true;
        				}
        			}
        		}
        	}
        } while(pass);
        System.out.println(count);
        return 0;
    }
	public static boolean check(ArrayList<ArrayList<Character>> list, int hi, int wi, char c, char ci) {
		if( hi<0 || wi <0 || list.size()-2<=hi || !(list.get(hi).size()-1>wi || list.get(hi+1).size()-1>wi) || list.get(hi).get(wi) == ci) return false;
		int[] ch = {hi,hi, hi+1, hi+1};
		int[] cw = {wi,wi+1, wi, wi+1};
		for(int i=1;i<4;i++) if(list.get(ch[i]).get(cw[i]) != c
				&& list.get(ch[i]).get(cw[i]) != ci) return false;
		for(int i=0;i<4;i++) list.get(ch[i]).set(cw[i],ci);
		check(list,hi-1,wi-1,c,ci);
		check(list,hi-1,wi,c,ci);
		check(list,hi-1,wi+1,c,ci);
		check(list,hi,wi-1,c,ci);
		check(list,hi,wi+1,c,ci);
		check(list,hi+1,wi-1,c,ci);
		check(list,hi+1,wi,c,ci);
		check(list,hi+1,wi+1,c,ci);
		return true;
	}
}