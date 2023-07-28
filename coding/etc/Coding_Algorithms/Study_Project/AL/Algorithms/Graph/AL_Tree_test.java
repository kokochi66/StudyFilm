package Algorithms.Graph;

import java.util.Arrays;

public class AL_Tree_test {
	
	
	
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int a) {
			this.data = a;
			this.left = null;
			this.right = null;
		}
		public Node(int a, Node l, Node r) {
			this.data = a;
			this.left = l;
			this.right = r;
		}
	}
	
	static class EdgeTree {
		
		public EdgeTree(int size) {
			
		}
	} // 전체 노드의 개수와 에지의 연결부분만이 주어지는 트리

}
