package Y2021.M03.D31;

public class Linked_kor {
	public static void main(String[] args) {
		LinkedList_kr list = new LinkedList_kr();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list.get(10));
	}
	
	static class LinkedList_kr {
		Node root;
		Node tail;
		int size;
		static class Node {
			int value;
			Node next;
			public Node(int v) {
				this.value = v;
				this.next = null;
			}	//노드 선언 함수
			public void setNext(Node n) {
				this.next = n;
			}	// 다음 노드값을 설정하는 함수
		}	// 한개의 노드 클래스
		
		public LinkedList_kr() {
			this.root = null;
			this.tail = null;
			this.size = 0;
		}	// LinkedList 선언함수
		
		
		
		public void add(int n) {
			if(size == 0) addFirst(n);
			else {
				this.tail.next = new Node(n);
				this.tail = this.tail.next;
			}
		}
		
		
		private void addFirst(int n) {
			this.root = new Node(n);
			this.tail = this.root;
			size++;
		}	// 첫번째 값을 추가할 때
		
		public int get(int n) {
			Node node = root;
			for(int i=0;i<n;i++) {
				node = node.next;
			}
			return node.value;
		}
		
		public void remove(int n) {
			Node node = root;
			for(int i=0;i<n-1;i++) {
				node = node.next;
			}
			
			
		}

	}
}
