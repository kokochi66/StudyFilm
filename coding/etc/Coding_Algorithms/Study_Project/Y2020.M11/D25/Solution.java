package D25;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		String[][] a = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}
		};
		solution(a);
	}
	
	public static int solution(String[][] relation) {
		int n = relation.length;
		int m = relation[0].length;
		boolean[] used = new boolean[m];
		boolean[] dused = new boolean[m];
		count = 0;
		for(int i=0;i<m;i++) {
			HashSet<String> set = new HashSet<String>();
			for(int j=0;j<n;j++) {
				if(!set.contains(relation[j][i])) {
					set.add(relation[j][i]);
				}
				else {
					used[i] = true;
					dused[i] = true;
					break;
				}
				
			}
			if(!used[i]) count++;
		}
//		System.out.println(Arrays.toString(used));
        for(int i=2;i<m-count;i++) {
        	int[] oper = new int[i];
        	btk(0,0,i,relation,oper,m,used,dused);
        }
        return count;
    }
	static int count;
	public static void btk(int k, int ci, int mi,String[][] rel, int[] oper, int m, boolean[] used, boolean[] dused) {
		if(k==mi) {
			HashSet<ArrayList<String>> ls = new HashSet<ArrayList<String>>();
			for(int i=0;i<rel.length;i++) {
				ArrayList<String> cl = new ArrayList<String>();
				for(int j=0;j<k;j++) {
					String c = rel[i][oper[j]];
					cl.add(c);
				}
				if(!ls.contains(cl)) {
					ls.add(cl);
				} else return;
			}
			for(int i=0;i<k;i++) dused[oper[i]] = false;
			count++;
		} else {
			for(int i=ci;i<m;i++) {
				if(used[i]) {
					used[i] = false;
					oper[k] = i;
					btk(k+1,i+1,mi,rel,oper,m,used,dused);
					if(dused[i]) used[i] = true;
				}
			}
		}
	}
}
