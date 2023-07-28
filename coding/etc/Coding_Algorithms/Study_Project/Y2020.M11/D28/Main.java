package D28;
import java.util.*;

import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		ArrayList<Node_s1> list = new ArrayList<Node_s1>();
		for(int i=0;i<n;i++) list.add(new Node_s1((char)('A'+i)));
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			int rt = (int)tok.nextToken().charAt(0)-'A';
			char cu1 = tok.nextToken().charAt(0);
			char cu2 = tok.nextToken().charAt(0);
			Node_s1 n1, n2;
			if(cu1!='.') n1 = list.get((int)(cu1-'A'));
			else n1 = null;
			if(cu2!='.') n2 = list.get((int)(cu2-'A'));
			else n2 = null;
			list.get(rt).setChild(n1, n2);
		}
		// 입력부
//		for(int i=0;i<n;i++) {
//			Node_s1 c = list.get(i);
//			System.out.println(c.data+" "+c.left+" "+c.right);
//		}
		
		
		//1. 전위 순회 : root -> left -> right
		Stack<Node_s1> st = new Stack<Node_s1>();
		st.add(list.get(0));
		while(!st.isEmpty()) {
			Node_s1 c = st.pop();
			wr.write(c.data);
			if(c.right != null) st.add(c.right);
			if(c.left != null) st.add(c.left);
		}
		wr.newLine();
		
		// 2. 중위 순회 : left -> root -> right
		boolean[] used = new boolean[n];
		st.add(list.get(0));
		while(!st.isEmpty()) {
			Node_s1 c = st.pop();
			if(c.left != null && !used[c.left.data-'A']) {
				st.add(c);
				st.add(c.left);
			} else {
				used[c.data-'A'] = true;
				wr.write(c.data);
				if(c.right != null && !used[c.right.data-'A']) st.add(c.right);
			}
		}
		wr.newLine();
		
		// 3. 후위 순회 : left -> right -> root
		used = new boolean[n];
		st.add(list.get(0));
		while(!st.isEmpty()) {
			Node_s1 c = st.pop();
			if(c.left != null && !used[c.left.data-'A']) {
				st.add(c);
				st.add(c.left);
			} else if(c.right != null && !used[c.right.data-'A']) {
				st.add(c);
				st.add(c.right);
			} else {
				used[c.data-'A'] = true;
				wr.write(c.data);
			}
		}
		wr.flush();
		
	}
	static class Node_s1 {
		char data;
		Node_s1 left;
		Node_s1 right;
		public Node_s1(char a) {
			this.data = a;
			this.left = null;
			this.right = null;
		}
		public Node_s1(char a, Node_s1 l, Node_s1 r) {
			this.data = a;
			this.left = l;
			this.right = r;
		}
		public void setChild(Node_s1 l, Node_s1 r) {
			this.left = l;
			this.right = r;
		}
	}
}